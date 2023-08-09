import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CurrencyRate } from './currencyRate';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {
  private apiServerUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public getAllCurrencys(): Observable<CurrencyRate[]>{
    return this.http.get<CurrencyRate[]>(`${this.apiServerUrl}/currency`);
  }

  public addCurrencyRate(currrencyRate: CurrencyRate): Observable<CurrencyRate> {
    return this.http.post<CurrencyRate>(`${this.apiServerUrl}/currency/add-currency`, currrencyRate);
  }

  public updateCurrencyRate(currencyId: number, currrencyRate: CurrencyRate): Observable<CurrencyRate> {
    return this.http.put<CurrencyRate>(`${this.apiServerUrl}/currency/${currencyId}/update`, currrencyRate);
  }

  public getCurrencyRateById(currencyId: number): Observable<CurrencyRate> {
    return this.http.get<CurrencyRate>(`${this.apiServerUrl}/currency/${currencyId}`);
  }

  getCurrencyByCode(code: string): Observable<CurrencyRate> {
    const url = `${this.apiServerUrl}/currency/currency/${code}`;
    return this.http.get<CurrencyRate>(url);
  }
  
  }
