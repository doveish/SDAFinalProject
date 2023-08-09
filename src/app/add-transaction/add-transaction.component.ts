import { Component, OnInit } from '@angular/core';
import { Account } from '../service/account';
import { Transaction } from '../service/transaction';
import { TransactionService } from '../service/transaction.service';
import { AccountService } from '../service/account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {

  selectedAccount: Account;
  transaction: Transaction = new Transaction;



  constructor(
    private transactionService: TransactionService,
    private accountService: AccountService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const accountId = +params.get('id');
      this.getAccount(accountId);
    });
    this.transaction.amount = 100;

  }

  public getAccount(accountId: number) {
    this.accountService.getAccount(accountId).subscribe((account) => {
      this.selectedAccount = account;
    });
  }

  public addTransactionToAccount(newTransaction: Transaction) {
    this.transactionService.addTransactionToAccount(this.selectedAccount.id, newTransaction).subscribe(data => {
      // this.goToTransactionList();
      console.log(data);
    },
      error => console.log(error));
  }

  public onSubmit(addTransactionForm: NgForm) {
    this.transactionService.addTransactionToAccount(this.selectedAccount.id, this.transaction).subscribe(() => {
      this.goToAccountList();
    }, error => console.log(error));
  }

  private goToAccountList() {
    this.router.navigate(['account']);
  }

  public getCurrentDate(): string {
    const today = new Date();
    const year = today.getFullYear();
    const month = (today.getMonth() + 1).toString().padStart(2, '0');
    const day = today.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }

}
