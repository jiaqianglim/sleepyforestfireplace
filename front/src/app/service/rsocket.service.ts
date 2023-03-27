import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { RSocketClient } from 'rsocket-core';
import { RSocketWebsocketClient } from 'rsocket-websocket-client';

@Injectable({
  providedIn: 'root',
})
export class RsocketService implements OnInit, OnDestroy {
  message = '';
  messages!: any[];
  client!: RSocketClient;
  sub = new Subject();

  constructor() {}
  ngOnInit(): void {
    this.messages = [];
  }
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
}
