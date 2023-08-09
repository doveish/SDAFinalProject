import { Component, OnInit } from '@angular/core';
import { Trade } from '../service/trade';
import { TradeService } from '../service/trade.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Stock } from '../service/stock';
import { StockService } from '../service/stock.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-trades',
  templateUrl: './view-trades.component.html',
  styleUrls: ['./view-trades.component.css']
})
export class ViewTradesComponent implements OnInit {
  public trades: Trade[];
  public selectedStock: Stock;
  public noTradeAlert: boolean = false;

  constructor(
    private tradeService: TradeService,
    private stockService: StockService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const urlSegment = this.route.snapshot.url[0].path;
    if (urlSegment === 'trade') {
      this.getTrades();
    } else if (urlSegment === 'stock') {

      this.getRouteStockId();
    }

  }

  public getRouteStockId() {
    this.route.paramMap.subscribe((params) => {
      const stockId = +params.get('id');
      this.getStock(stockId);
      this.getStockTradeList(stockId);
    });
  }

  public getTrades(): void {
    this.tradeService.getAllTrades().subscribe(
      {
        next: (response: Trade[]) => {
          console.log(response);
          this.trades = response;
        },
        error: (error: HttpErrorResponse) => 
        console.log(error),
        complete: () => console.log("completed")
      }
    );
  }

  public getStock(stockId: number) {
    this.stockService.getStock(stockId).subscribe((stock) => {
      this.selectedStock = stock;
    });
  }

  public getStockTradeList(stockId: number): void {
    this.tradeService.getStockTradeList(stockId).subscribe(
      (response: Trade[]) => {
        console.log(response);
        this.trades = response;
        this.noTradeAlert = this.trades.length === 0;
      },
      (error: HttpErrorResponse) =>
      console.log(error),
      () => console.log('completed')
    );
  }


  public showStockName(): boolean {
    const currentUrl = this.router.url;
    const stockId = this.route.snapshot.paramMap.get('id');
    return currentUrl.includes(`/stock/${stockId}/trade-list`);
  }

  public showAddTradeButton(): boolean {
    const currentUrl = this.router.url;
    const stockId = this.route.snapshot.paramMap.get('id');
    return currentUrl.includes(`/stock/${stockId}/trade-list`);
  }

  public goToAddTrade(stockId: number) {
    this.router.navigate([`/stock/${stockId}/createTrade`]);
  }

}
