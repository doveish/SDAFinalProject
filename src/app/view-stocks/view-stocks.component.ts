import { Component, OnInit } from '@angular/core';
import { Stock } from '../service/stock';
import { StockService } from '../service/stock.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../service/account.service';
import { Account } from '../service/account';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-view-stocks',
  templateUrl: './view-stocks.component.html',
  styleUrls: ['./view-stocks.component.css']
})
export class ViewStocksComponent implements OnInit {
  public stocks: Stock[];
  public selectedAccount: Account;
  public noStockAlert: boolean = false;
  

  constructor(
    private stockService: StockService,
    private accountService: AccountService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const urlSegment = this.route.snapshot.url[0].path;
    if (urlSegment === 'stock') {
      this.getStocks();

    } else if (urlSegment === 'account') {
      this.getRouteForAccountId()
    }

  }

  public getAccount(accountId: number) {
    this.accountService.getAccount(accountId).subscribe((account) => {
      this.selectedAccount = account;
    });
  }

  public getStocks(): void {
    this.stockService.getAllStocks().subscribe(
      {
        next: (response: Stock[]) => {
          console.log(response);
          this.stocks = response;
        },
        error: (error: HttpErrorResponse) => 
        console.log(error),
        complete: () => console.log("completed")
      }
    );
  }

  public getRouteForAccountId() {
    this.route.paramMap.subscribe((params) => {
      const accountId = +params.get('id');
      this.getAccount(accountId);
      this.getAccountStockList(accountId);
    });

  }

  public goToAddTrade(stockId: number) {
    this.router.navigate([`/stock/${stockId}/createTrade`]);
  }

  public goToAddDividend(stockId: number) {
    this.router.navigate([`/stock/${stockId}/createDividend`]);
  }

  public getAccountStockList(accountId: number): void {
    this.stockService.getAccountStockList(accountId).subscribe(
      (response: Stock[]) => {
        console.log(response);
        this.stocks = response;
        this.noStockAlert = this.stocks.length === 0;
      },
      (error: HttpErrorResponse) => alert(error.message),
      () => console.log('completed')
    );
  }

  public goToStockTradeList(stockId: number) {
    this.router.navigate(['/stock', stockId, 'trade-list']);
  }

  public goToStockDividendList(stockId: number) {
    this.router.navigate(['/stock', stockId, 'dividend-list']);
  }

  public getProfitSum(profitLoss): number {
    let sum = 0;
    for (let i = 0; i < this.stocks.length; i++) {
      sum += this.stocks[i].profitLoss;
    }
    return sum;
  }

  public getMarketValueSum(totalMarketValue): number {
    let sum = 0;
    for (let i = 0; i < this.stocks.length; i++) {
      sum += this.stocks[i].totalMarketValue;
    }
    return sum;
  }

  public goToAddStock(accountId: number) {
    this.router.navigate([`/account/${accountId}/createStock`]);
  }

  public showAddStockButton(): boolean {
    const currentUrl = this.router.url;
    const accountId = this.route.snapshot.paramMap.get('id');
    return currentUrl.includes(`/account/${accountId}/stock-list`);
  }

  public showAccountName(): boolean {
    const currentUrl = this.router.url;
    const accountId = this.route.snapshot.paramMap.get('id');
    return currentUrl.includes(`/account/${accountId}/stock-list`);
  }

  public showAccount(): boolean {
    const currentUrl = this.router.url;
    const accountId = this.route.snapshot.paramMap.get('id');
    return currentUrl.includes('/stock') && !currentUrl.includes(`/account/${accountId}/stock-list`);
  }






}
