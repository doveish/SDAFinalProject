import { Component } from '@angular/core';
import { Account } from '../service/account';
import { AccountService } from '../service/account.service';
import { HttpErrorResponse } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StockService } from '../service/stock.service';
import { CurrencyService } from '../service/currencyRate.service';
import { CurrencyRate } from '../service/currencyRate';

@Component({
  selector: 'app-view-accounts',
  templateUrl: './view-accounts.component.html',
  styleUrls: ['./view-accounts.component.css']
})

export class ViewAccountsComponent implements OnInit {
  public accounts: Account[];
  selectedAccount: Account;
  public calculatedBalances: { [accountId: number]: number } = {};

  constructor(private accountService: AccountService,
    private stockService: StockService,
    private router: Router,
    private route: ActivatedRoute,
    private currencyService: CurrencyService) { }

  ngOnInit(): void {

  
    this.getAccountList();
    this.getRoutetoAccountId();

  }

  public getRoutetoAccountId() {
    this.route.paramMap.subscribe((params) => {
      const accountId = +params.get('id');
      this.getAccount(accountId);
    });
  }

  public getAccount(accountId: number) {
    this.accountService.getAccount(accountId).subscribe((account) => {
      this.selectedAccount = account;
    });
  }

 public getAccountList() {
    this.accountService.getAccounts().subscribe((accounts) => {
      this.accounts = accounts;
      this.calculateBalances();
    });
  }

  public goToAddStock(accountId: number) {
    this.router.navigate([`/account/${accountId}/createStock`]);
  }

  public goAddWithdraw(accountId: number) {
    this.router.navigate([`/account/${accountId}/createTransaction`]); 
  }

  public goToAccountStockList(accountId: number) {
    this.router.navigate(['/account', accountId, 'stock-list']);
  }

  public getAccountSum(balance) : number {
    let sum = 0;
    for(let i = 0; i < this.accounts.length; i++) {
      sum += this.accounts[i].balance;
    }
    return sum;
  }

  public goToAccountTransactionList(accountId: number) {
    this.router.navigate(['/account', accountId, 'transaction-list']);
  }

  private calculateBalances(): void {
    this.accounts.forEach((account) => {
      this.currencyService.getCurrencyByCode(account.currency).subscribe(
        (currencyRate: CurrencyRate) => {
          const balanceInDesiredCurrency = account.balance / currencyRate.rate;
          this.calculatedBalances[account.id] = balanceInDesiredCurrency;
        },
        (error) => {
          console.error('Error fetching currency rate:', error);
        }
      );
    });
  }

}
