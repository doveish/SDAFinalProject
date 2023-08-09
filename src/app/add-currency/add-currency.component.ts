import { Component, OnInit } from '@angular/core';
import { CurrencyRate } from '../service/currencyRate';
import { CurrencyService } from '../service/currencyRate.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-currency',
  templateUrl: './add-currency.component.html',
  styleUrls: ['./add-currency.component.css']
})
export class AddCurrencyComponent implements OnInit {

  currencyRate: CurrencyRate = new CurrencyRate;
  isUpdateMode: boolean;

  constructor(
    private currencyRateService: CurrencyService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isUpdateMode = true;
        const currencyId = params['id'];
        this.currencyRateService.getCurrencyRateById(currencyId).subscribe(
          response => {
            this.currencyRate = response;
          },
          error => console.error(error)
        );
      } else {
        this.isUpdateMode = false;
      }
    });
  }

  public onSubmit(addCurrencyRateForm: NgForm) {
    if (this.isUpdateMode) {
      this.currencyRateService.updateCurrencyRate(this.currencyRate.id, this.currencyRate).subscribe(
        () => {
          this.goToCurrencyRateList();
        },
        error => console.error(error)
      );
    } else {
      this.currencyRateService.addCurrencyRate(this.currencyRate).subscribe(
        () => {
          this.goToCurrencyRateList();
        },
        error => console.error(error)
      );
    }
  }

  private goToCurrencyRateList() {
    this.router.navigate(['currency']);
  }


}
