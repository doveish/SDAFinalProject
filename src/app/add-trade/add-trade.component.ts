import { Component, OnInit } from '@angular/core';
import { Stock } from '../service/stock';
import { Trade } from '../service/trade';
import { TradeService } from '../service/trade.service';
import { ActivatedRoute, Router } from '@angular/router';
import { StockService } from '../service/stock.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-trade',
  templateUrl: './add-trade.component.html',
  styleUrls: ['./add-trade.component.css']
})
export class AddTradeComponent implements OnInit {

  selectedStock: Stock;
  newTrade: Trade = new Trade();


  constructor(
    private tradeService: TradeService,
    private stockService: StockService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const stockId = +params.get('id');
      this.getStock(stockId);
    });
  }

  public getStock(stockId: number) {
    this.stockService.getStock(stockId).subscribe((stock) => {
      this.selectedStock = stock;
    });
  }

  public addTradeToStock(newTrade: Trade) {
    this.tradeService.addTradeToStock(this.selectedStock.id, newTrade).subscribe(data => {
      this.goToTradeList();
      console.log(data);
    },

      error => console.log(error));
  }

  public onSubmit(addTradeForm: NgForm) {
    this.tradeService.addTradeToStock(this.selectedStock.id, this.newTrade).subscribe(() => {
      this.goToTradeList();
    }, error => console.log(error));

  }
  private goToTradeList() {
    this.router.navigate(['trade']);
  }

  public getCurrentDate(): string {
    const today = new Date();
    const year = today.getFullYear();
    const month = (today.getMonth() + 1).toString().padStart(2, '0');
    const day = today.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }


}
