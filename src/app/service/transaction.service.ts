import { Injectable } from '@angular/core';
import { Transaction } from './transaction';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private apiServerUrl = "http://localhost:8080";

   constructor(private http: HttpClient) { }

  public addTransactionToAccount(accountId: number, transaction: Transaction): Observable<any> {
    return this.http.post(`${this.apiServerUrl}/account/${accountId}/balance-update-by-transaction`, transaction);
  }

  
  public getAccountTransactionList(accountId: number): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.apiServerUrl}/account/${accountId}/transaction-list`);
  }

}
