import { Component } from '@angular/core';
import { RSocketConnector } from 'rsocket-core';
import { WebsocketClientTransport } from 'rsocket-websocket-client';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-rsocketstream',
  templateUrl: './rsocketstream.component.html',
  styleUrls: ['./rsocketstream.component.css'],
})
export class RsocketstreamComponent {
  rsocket!: RSocketConnector;



  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.rsocket = new RSocketConnector({
      transport: new WebsocketClientTransport({
        url: 'ws://localhost8080',
        wsCreator: (url) => new WebSocket(url) as any,
      }),
    });
    this.rsocket.connect();
  }
}
