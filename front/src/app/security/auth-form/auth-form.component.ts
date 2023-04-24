import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewEncapsulation,
} from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormGroupDirective,
  NgForm,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.component.html',
  styleUrls: ['./auth-form.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class AuthFormComponent implements OnInit {
  loginform!: FormGroup;
  action: string = 'Login';
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);
  normalFormControl = new FormControl('', [Validators.required]);
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.checkJWT();
  }
  ngOnInit(): void {
    this.loginform = this.fb.group({
      username: ['', [Validators.required]],
      email: ['', [Validators.email, Validators.required]],
      password: ['', Validators.required],
      membership: [''],
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
        localStorage.setItem('token', data.token);
        localStorage.setItem('email', this.loginform.get('email')?.value);
        this.router.navigate(['/']);
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
      if (this.authService.isAuthenticated()) {
        this.router.navigate(['/']);
      }
    }
  }
}
