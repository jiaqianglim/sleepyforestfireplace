import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  constructor(private authService: AuthService, private router: Router) {}
  submit(data: { email: string; password: string }) {
    this.authService.register(data).subscribe((data) => {
      this.router.navigate(['/']);
    });
  }
}
