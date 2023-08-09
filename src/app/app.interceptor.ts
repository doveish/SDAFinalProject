import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AppInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if(request.url.indexOf('authenticate') < 1) {
      request = request.clone({
        headers: request.headers.set('Content-Type', 'application/json')
      });

      const tokenStr = 'Bearer ' + sessionStorage.getItem('token');

      request = request.clone({
        headers: request.headers.set('Authorization', tokenStr)
      });
    }

    return next.handle(request);
  }
}
