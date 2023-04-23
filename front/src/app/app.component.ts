import { Component } from '@angular/core';
import { AuthService } from './security/auth.service';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Coding Sucks';
  url: string = '';
  constructor(private authsvc: AuthService, private router: Router) {
    this.getRoute();
  }
  submit(action: String) {
    switch (action) {
      case 'logout':
        this.authsvc.logout();
        break;
      default:
        break;
    }
  }
  getRoute() {
    this.router.events.subscribe((data) => {
      if (data instanceof NavigationEnd) {
        this.url = data.url;
      }
    });
  }
}
