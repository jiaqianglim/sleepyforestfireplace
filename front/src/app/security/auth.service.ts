import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

const ENVIRONMENT = environment.WEBMVC;

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(
    private http: HttpClient,
    private jwtHelper: JwtHelperService,
    private router: Router
  ) {}

  isAuthenticated(): boolean {
    const token = localStorage.getItem('token') ?? '';
    return !this.jwtHelper.isTokenExpired(token);
  }

  login(data: {
    email: string;
    password: string;
    username: string;
    membership: string;
  }): Observable<any> {
    return this.http.post<any>(`${ENVIRONMENT}/login`, data).pipe(
      tap((data: any) => data),
      catchError((err) => throwError(() => err))
    );
  }

  register(data: {
    email: string;
    password: string;
    username: string;
    membership: string;
  }): Observable<any> {
    return this.http.post<any>(`${ENVIRONMENT}/register`, data).pipe(
      tap((data: any) => data),
      catchError((err) => throwError(() => err))
    );
  }

  logout() {
    let removeToken = localStorage.removeItem('token');
    if (removeToken == null) {
      this.router.navigate(['login']);
    }
  }
}
