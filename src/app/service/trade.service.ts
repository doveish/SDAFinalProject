import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Trade } from './trade';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TradeService {

  private apiServerUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public getAllTrades(): Observable<Trade[]>{
    return this.http.get<Trade[]>(`${this.apiServerUrl}/trade`);
  }


  public addTradeToStock(stockId: number, trade: Trade): Observable<any> {
    return this.http.post(`${this.apiServerUrl}/stock/${stockId}/createTrade`, trade);
  }

  public getStockTradeList(stockId: number): Observable<Trade[]> {
    return this.http.get<Trade[]>(`${this.apiServerUrl}/stock/${stockId}/trade-list`);
  }
}
