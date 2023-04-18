import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.component.html',
  styleUrls: ['./auth-form.component.css'],
})
export class AuthFormComponent {
  loginform: FormGroup;
  action: string = 'Login';

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginform = this.fb.group({
      email: ['', [Validators.email, Validators.required]],
      password: ['', Validators.required],
    });
  }
  chooseLogin() {
    this.action = 'Login';
  }
  chooseRegister() {
    this.action = 'Register';
  }

  submit() {
    const data = this.loginform.value;
    if (this.action == 'Login') {
      this.authService.login(data).subscribe((data) => {
        this.router.navigate(['/']);
        localStorage.setItem('token', data.token);
      });
    }
    if (this.action == 'Register') {
      this.authService.register(data).subscribe((data) => {
        this.router.navigate(['/login']);
      });
    }
  }
  checkJWT() {
    if (this.authService.isAuthenticated()) {
      //TODO
    }
  }
}
