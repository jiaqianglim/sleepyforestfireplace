import { Component, NgZone, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-chatcontainer',
  templateUrl: './chatcontainer.component.html',
  styleUrls: ['./chatcontainer.component.css'],
})
export class ChatcontainerComponent implements OnInit, OnDestroy {
  message = 'testmessage';
  messages!: string[];
  socket!: WebSocket;
  constructor(private zone: NgZone) {}
  ngOnInit(): void {
    this.messages = ['test message 1', 'test message 2'];
    this.socket = new WebSocket('ws://localhost:8080/ws/messages');
    console.log('websocket created');
    this.socket.onmessage = (event) => {
      this.zone.run(() => {
        this.addMessage(event.data);
      });
    };
  }

  addMessage(msg: any) {
    this.messages = [...this.messages, msg];
  }

  ngOnDestroy(): void {}

  sendMessage() {
    this.socket.send(this.message);
    console.log('button clicked');
  }
}
