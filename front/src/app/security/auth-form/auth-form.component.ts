import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.component.html',
  styleUrls: ['./auth-form.component.css'],
})
export class AuthFormComponent {
  @Input() error: String = '';
  @Input() title: string = 'Login';
  @Output() submitEmitter = new EventEmitter();

  loginform: FormGroup;

  constructor(private fb: FormBuilder) {
    this.loginform = this.fb.group({
      email: ['', [Validators.email, Validators.required]],
      password: ['', Validators.required],
    });
  }

  submit() {
    this.submitEmitter.emit(this.loginform.value);
  }
}
