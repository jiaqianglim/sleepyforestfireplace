import { Injectable } from '@angular/core';
import { RSocket, RSocketConnector } from 'rsocket-core';
import { WebsocketClientTransport } from 'rsocket-websocket-client';
import { Codec } from 'rsocket-messaging';
import { RxRequestersFactory, RxRespondersFactory } from 'rsocket-adapter-rxjs';

class StringCodec implements Codec<string> {
  readonly mimeType: string = 'text/plain';

  decode(buffer: Buffer): string {
    return buffer.toString();
  }

  encode(entity: string): Buffer {
    return Buffer.from(entity);
  }
}

@Injectable({
  providedIn: 'root',
})
export class RsocketclientService {
  wsURL: string = 'ws://localhost:8000/rsocket';
  connector!: RSocketConnector;

  ngOnInit(): void {}

  makeConnector(): RSocketConnector {
    return new RSocketConnector({
      setup: {
        keepAlive: 100,
        lifetime: 10000,
      },
      transport: new WebsocketClientTransport({
        url: this.wsURL,
        wsCreator: (url) => new WebSocket(url),
      }),
    });
  }

}
