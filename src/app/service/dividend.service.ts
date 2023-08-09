import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Dividend } from './dividend';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DividendService {

  private apiServerUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public getAllDividends(): Observable<Dividend[]>{
    return this.http.get<Dividend[]>(`${this.apiServerUrl}/dividend`);
  }

  public addDividendToStock(stockId: number, dividend: Dividend): Observable<any> {
    return this.http.post(`${this.apiServerUrl}/stock/${stockId}/createDividend`, dividend);
  }

  public getStockDividendList(stockId: number): Observable<Dividend[]> {
    return this.http.get<Dividend[]>(`${this.apiServerUrl}/stock/${stockId}/dividend-list`);
  }

}
