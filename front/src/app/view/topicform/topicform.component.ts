import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-topicform',
  templateUrl: './topicform.component.html',
  styleUrls: ['./topicform.component.css'],
})
export class TopicformComponent implements OnInit {
  topicForm!: FormGroup;
  topicTab!: FormArray;
  constructor(private fb: FormBuilder, private http: HttpClient) {}
  ngOnInit(): void {
    this.topicForm = this.fb.group({
      name: this.fb.control<string>('', Validators.required),
      description: this.fb.control<string>('', [
        Validators.maxLength(1000),
        Validators.required,
      ]),
      date: this.fb.control<string>('', [
        Validators.required,
        Validators.pattern(
          /^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/
        ),
      ]),
    });
  }

  addcustomtab() {}
  processform() {}
}
