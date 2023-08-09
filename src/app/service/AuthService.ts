import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { map } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedInSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public loggedIn$: Observable<boolean> = this.loggedInSubject.asObservable();

  // public username: string;
  // public password: string;

  constructor(private http: HttpClient) {

  }

  login(username: string, password: string): Observable<any> {
    return this.http.get(environment.hostUrl + `/authenticate`, {
      headers: { authorization: this.createBasicAuthToken(username, password) }
    }).pipe(
      map((res) => {
        this.registerSuccessfulLogin();
        this.loggedInSubject.next(true);
      })
    );
  }

  logout(): void {

    this.loggedInSubject.next(false);
  }

  private registerSuccessfulLogin(): void {
    

  }

  private createBasicAuthToken(username: string, password: string): string {
    return 'Basic ' + window.btoa(username + ":" + password);
  }
}