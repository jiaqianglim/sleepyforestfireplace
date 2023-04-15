import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(private authService: AuthService, private router: Router) {
    this.checkJWT();
  }
  submit(data: { email: string; password: string }) {
    this.authService.login(data).subscribe((data) => {
      this.router.navigate(['/home']);
      localStorage.setItem('token', data.token);
    });
  }
  checkJWT() {
    if (this.authService.isAuthenticated()) {
      //TODO
    }
  }
}
