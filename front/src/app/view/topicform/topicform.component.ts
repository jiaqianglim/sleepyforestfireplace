import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-topicform',
  templateUrl: './topicform.component.html',
  styleUrls: ['./topicform.component.css'],
})
export class TopicformComponent {
  
  constructor(private fb: FormBuilder, private http: HttpClient) {}

  processform() {}
}
