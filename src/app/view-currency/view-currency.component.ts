import { Component, OnInit } from '@angular/core';
import { CurrencyRate } from '../service/currencyRate';
import { CurrencyService } from '../service/currencyRate.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-currency',
  templateUrl: './view-currency.component.html',
  styleUrls: ['./view-currency.component.css']
})
export class ViewCurrencyComponent implements OnInit {

  public currencyRates: CurrencyRate[];

  constructor(
    private currencyRateService: CurrencyService,
    private router: Router,
  ){
  }
  ngOnInit(): void {
    this.getCurrencyRates();
    
  }

  public getCurrencyRates(): void {
    this.currencyRateService.getAllCurrencys().subscribe(
      {
        next: (response: CurrencyRate[]) => {
          console.log(response);
          this.currencyRates = response;
        },
        error: (error: HttpErrorResponse) => 
        console.log(error),
        complete: () => console.log("completed")
      }
    );
}

public goUpdateCurrencyRate(currencyId: number) {
  this.router.navigate([`/currency/${currencyId}/update`]);
}

}
