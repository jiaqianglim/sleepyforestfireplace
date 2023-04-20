import { Component } from '@angular/core';
import { RsocketclientService } from '../rsocketclient.service';
import { webSocket } from 'rxjs/webSocket';

@Component({
  selector: 'app-rsocketchatbox',
  templateUrl: './rsocketchatbox.component.html',
  styleUrls: ['./rsocketchatbox.component.css'],
})
export class RsocketchatboxComponent {
  constructor(private rcs: RsocketclientService) {}
  title = 'client';
  message = '';
  messages!: any[];

  async ngOnInit() {
    const connector = this.rcs.makeConnector();
    const rsocket = await connector.connect();
    await new Promise((resolve, reject) => {
      let payloadsReceived = 0;
      const maxPayloads = 10;
      const requester = rsocket.requestStream(
        {
          data: Buffer.from('Hello World'),
        },
        3,
        {
          onError: (e) => reject(e),
          onNext: (payload) => {
            console.log(payload);

            payloadsReceived++;
          },
          onComplete: () => {
            resolve(null);
          },
          onExtension: () => {},
        }
      );
    });
  }
}
