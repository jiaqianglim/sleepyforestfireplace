import { Injectable, OnInit } from '@angular/core';
import {
  Cancellable,
  OnExtensionSubscriber,
  OnNextSubscriber,
  OnTerminalSubscriber,
  Payload,
  RSocket,
  Requestable,
} from 'rsocket-core';
import { WebsocketClientTransport } from 'rsocket-websocket-client';
import {
  ClientTransport,
  Closeable,
  Demultiplexer,
  DuplexConnection,
  FrameHandler,
  Multiplexer,
  Outbound,
} from 'rsocket-core';
import { ClientOptions } from 'rsocket-websocket-client/RSocketWebSocketClient';
import { webSocket } from 'rxjs/webSocket';
import { RSocketConnector } from 'rsocket-core';
@Injectable({
  providedIn: 'root',
})
export class RsocketserviceService implements RSocket, OnInit {
  constructor() {}
  options: ClientOptions = {
    url: 'wss://localhost:7070',
  };
  clienttransport!: WebsocketClientTransport;
  subject = webSocket('ws://localhost:7070');

  ngOnInit(): void {
    this.clienttransport = new WebsocketClientTransport(this.options);
    const connector = this.makeconnector();
    const rsocket = connector.connect();
  }
  makeconnector(){
    return new RSocketConnector({
      transport: this.clienttransport
    })
  }
  fireAndForget(
    payload: Payload,
    responderStream: OnTerminalSubscriber
  ): Cancellable {
    throw new Error('Method not implemented.');
  }
  requestResponse(
    payload: Payload,
    responderStream: OnTerminalSubscriber &
      OnNextSubscriber &
      OnExtensionSubscriber
  ): Cancellable & OnExtensionSubscriber {
    throw new Error('Method not implemented.');
  }
  requestStream(
    payload: Payload,
    initialRequestN: number,
    responderStream: OnTerminalSubscriber &
      OnNextSubscriber &
      OnExtensionSubscriber
  ): Requestable & Cancellable & OnExtensionSubscriber {
    throw new Error('Method not implemented.');
  }
  requestChannel(
    payload: Payload,
    initialRequestN: number,
    isCompleted: boolean,
    responderStream: OnTerminalSubscriber &
      OnNextSubscriber &
      OnExtensionSubscriber &
      Requestable &
      Cancellable
  ): OnTerminalSubscriber &
    OnNextSubscriber &
    OnExtensionSubscriber &
    Requestable &
    Cancellable {
    throw new Error('Method not implemented.');
  }
  metadataPush(metadata: Buffer, responderStream: OnTerminalSubscriber): void {
    throw new Error('Method not implemented.');
  }
  close(error?: Error | undefined): void {
    throw new Error('Method not implemented.');
  }
  onClose(callback: (error?: Error | undefined) => void): void {
    throw new Error('Method not implemented.');
  }
}
function ngOnInit() {
  throw new Error('Function not implemented.');
}
