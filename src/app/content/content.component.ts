import { Component, OnInit } from '@angular/core';
import { ApexChart, ApexNonAxisChartSeries, ApexTitleSubtitle } from 'ng-apexcharts';
import { StockService } from '../service/stock.service';
import { Stock } from '../service/stock';
import { AccountService } from '../service/account.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  chartSeries: ApexNonAxisChartSeries = [];
  

  charDetalis: ApexChart = {
    type: 'pie',
    toolbar: {
       show: true
    }
  };

  chartLabels = [];
  chartTitle: ApexTitleSubtitle = {
    text: 'Your portfolio',
    align:'center'
  }


  constructor(private stockService: StockService,
    private accountService: AccountService) { }

  ngOnInit(): void {
    this.loadStockData();
    
  }

  public loadStockData(): void {
    this.stockService.getAllStocks().subscribe((stocks: Stock[]) => {
            this.chartSeries = stocks.map(stock => stock.totalMarketValue);
            this.chartLabels = stocks.map(stock => stock.stockName);
    });
    
  }

  


}
