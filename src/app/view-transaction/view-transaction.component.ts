import { Component, OnInit } from '@angular/core';
import { Transaction } from '../service/transaction';
import { Account } from '../service/account';
import { TransactionService } from '../service/transaction.service';
import { AccountService } from '../service/account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-view-transaction',
  templateUrl: './view-transaction.component.html',
  styleUrls: ['./view-transaction.component.css']
})
export class ViewTransactionComponent implements OnInit {

  public transactions: Transaction[];
 public selectedAccount: Account;
  
  constructor(
    private transactionService: TransactionService,
    private accountService: AccountService,
    private router: Router,
    private route: ActivatedRoute
  ){}
  ngOnInit(): void {
   this.getRouteForAccountId()
  }

  public getRouteForAccountId() {
    this.route.paramMap.subscribe((params) => {
      const accountId = +params.get('id');
      this.getAccount(accountId);
      this.getAccountTransactionList(accountId);
    });
  }

  public getAccount(accountId: number) {
    this.accountService.getAccount(accountId).subscribe((account) => {
      this.selectedAccount = account;
    });
  }
    
  public getAccountTransactionList(accountId: number): void {
    this.transactionService.getAccountTransactionList(accountId).subscribe(
      (response: Transaction[]) => {
        console.log(response);
        this.transactions = response;
      },
      (error: HttpErrorResponse) => 
      console.log(error),
      () => console.log('completed')
    );
  }
  

}
