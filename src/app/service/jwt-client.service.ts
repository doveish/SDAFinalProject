import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {
  constructor(private httpClient: HttpClient) {}

  generateToken(request: any) {
    return this.httpClient.post<string>('http://localhost:8080/authenticate', request, {
      responseType: 'text' as 'json'
    });
  }

  welcome(token: string) {
   
    return this.httpClient.get<string>('http://localhost:8080/', { responseType: 'text' as 'json' });
  }
}
