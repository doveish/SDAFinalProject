import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Trade } from '../service/trade';

import { Dividend } from '../service/dividend';
import { DividendService } from '../service/dividend.service';
import { StockService } from '../service/stock.service';
import { Stock } from '../service/stock';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-dividends',
  templateUrl: './view-dividends.component.html',
  styleUrls: ['./view-dividends.component.css']
})
export class ViewDividendsComponent implements OnInit {
  public dividends: Dividend[];
  public selectedStock: Stock;
  public noDividendAlert: boolean = false;

  constructor(
    private dividendService: DividendService,
    private stockService: StockService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const urlSegment = this.route.snapshot.url[0].path;
    if (urlSegment === 'dividend') {
      this.getDividends();
    } else if (urlSegment === 'stock') {
      this.getRouteStockId();
    }
  }

  public getRouteStockId() {
    this.route.paramMap.subscribe((params) => {
      const stockId = +params.get('id');
      this.getStock(stockId);
      this.getStockDividendList(stockId);
    });
  }

  public getStock(stockId: number) {
    this.stockService.getStock(stockId).subscribe((stock) => {
      this.selectedStock = stock;
    });
  }

  public getStockDividendList(stockId: number): void {
    this.dividendService.getStockDividendList(stockId).subscribe(
      (response: Dividend[]) => {
        console.log(response);
        this.dividends = response;
        this.noDividendAlert = this.dividends.length === 0;
      },
      (error: HttpErrorResponse) => alert(error.message),
      () => console.log('completed')
    );
  }


  public getDividends(): void {
    this.dividendService.getAllDividends().subscribe(
      {
        next: (response: Dividend[]) => {
          console.log(response);
          this.dividends = response;
        },
        error: (error: HttpErrorResponse) => 
        console.log(error),
        complete: () => console.log("completed")
      }
    );
  }

  public showStockName(): boolean {
    const currentUrl = this.router.url;
    const stockId = this.route.snapshot.paramMap.get('id');
    return currentUrl.includes(`/stock/${stockId}/dividend-list`);
  }

}
