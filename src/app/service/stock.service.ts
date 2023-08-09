import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Stock } from './stock';
import { Observable } from 'rxjs';
import { Account } from './account';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  private apiServerUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public getAllStocks(): Observable<Stock[]>{
    return this.http.get<Stock[]>(`${this.apiServerUrl}/stock`);
  }

  public getStock(stockId: number): Observable<Stock> {
    return this.http.get<Stock>(`${this.apiServerUrl}/stock/id/${stockId}`);
  }

  public addStockToAccount(accountId: number, stock: Stock): Observable<any> {
    return this.http.post(`${this.apiServerUrl}/account/${accountId}/create-stock`, stock);
  }

  public getAccountStockList(accountId: number): Observable<Stock[]> {
    return this.http.get<Stock[]>(`${this.apiServerUrl}/account/${accountId}/stock-list`);
  }

  

}
