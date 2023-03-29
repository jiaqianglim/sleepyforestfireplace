import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { basic_user } from '../model/basic_user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}
  login(email: string, password: string) {
    return this.http.post<basic_user>('/api/login', { email, password });
  }
}
