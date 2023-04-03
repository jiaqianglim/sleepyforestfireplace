import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { webSocket } from 'rxjs/webSocket';

@Component({
  selector: 'app-chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.css'],
})
export class ChatroomComponent implements OnInit {
  subject: any | undefined;

  ngOnInit(): void {
    this.subject = webSocket('ws://localhost:8090');
    this.subject.subscribe({
      next: (msg: any) => console.log(msg),
      error: (err: any) => console.log(err),
      complete: () => console.log('complete'),
    });
  }

  send(msg: String) {
    this.subject.next({ msg });
  }
}
