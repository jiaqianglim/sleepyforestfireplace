import { Component } from '@angular/core';
import { RxRequestersFactory } from 'rsocket-adapter-rxjs';
import { RSocket } from 'rsocket-core';
import { RsocketService } from 'src/app/service/rsocketsocket.service';
import { StringCodec } from 'src/app/utils/stringCodec';
import { firstValueFrom, take, tap } from 'rxjs';

@Component({
  selector: 'app-rsocketchat',
  templateUrl: './rsocketchat.component.html',
  styleUrls: ['./rsocketchat.component.css'],
})
export class RsocketchatComponent {

  rsocket!: RSocket;
  stringCodec = new StringCodec();
  constructor(private rsservice: RsocketService) {}

  ngOnInit(): void {
  }

  requestStream(rsocket: RSocket) {
    const request = RxRequestersFactory.requestStream(
      'hello world',
      this.stringCodec,
      this.stringCodec,
      5
    );
    const source$ = request(rsocket).pipe(
      tap((data: any) => {
        console.log(`[client] received[data: ${data}]`);
      }),
      take(10)
    );
    return firstValueFrom(source$);
  }
}
