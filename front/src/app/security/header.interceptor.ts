import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HeaderInterceptor implements HttpInterceptor {
  intercept(
    httpRequest: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const Authorization = localStorage.getItem('token')
      ? `Bearer ${localStorage.getItem('token')}`
      : '';
    if (httpRequest.url.includes('api/'))
      return next.handle(httpRequest.clone({ setHeaders: { Authorization } }));
    else return next.handle(httpRequest);
  }
}
