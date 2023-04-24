import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-toptoolbar',
  templateUrl: './toptoolbar.component.html',
  styleUrls: ['./toptoolbar.component.css'],
})
export class ToptoolbarComponent implements OnInit {
  @Output() actionEmitter = new EventEmitter();
  @Input() loggedIn = false;
  submit(action: string) {
    this.actionEmitter.emit(action);
  }
  constructor(private router: Router) {}
  ngOnInit(): void {}

  gohome() {
    this.router.navigate(['/']);
  }
}
