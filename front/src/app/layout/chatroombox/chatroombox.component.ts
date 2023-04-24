import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ChatMessage } from 'src/app/model/chatmessage';
import { environment } from 'src/environments/environment';
import { RxStomp } from '@stomp/rx-stomp';

const WEBFLUX = environment.WEBFLUX;

@Component({
  selector: 'app-chatroombox',
  templateUrl: './chatroombox.component.html',
  styleUrls: ['./chatroombox.component.css'],
})
export class ChatroomboxComponent implements OnInit, OnDestroy {
  @Input() chattopic!: string;
  inputForm!: FormGroup;
  constructor(private fb: FormBuilder) {}
  chatmessage!: ChatMessage;
  chatmessage1!: ChatMessage;
  chatmessage2!: ChatMessage;
  messages!: ChatMessage[];
  rxStomp!: RxStomp;
  subscription: any;

  ngOnInit(): void {
    this.chatmessage1 = {
      username: 'Admin',
      messagebody: 'Join this community and start chatting!',
    };
    this.chatmessage2 = {
      username: 'John',
      messagebody: 'First!',
    };
    this.messages = [];
    this.messages.push(this.chatmessage1);
    this.messages.push(this.chatmessage2);
    this.inputForm = this.fb.group({
      username: this.fb.control<string>(''),
      messagebody: this.fb.control<string>('', Validators.required),
    });
    this.rxStomp = new RxStomp();
    this.rxStomp.configure({
      brokerURL: `ws://${WEBFLUX}/api`,
    });
    this.rxStomp.activate();
    this.subscription = this.rxStomp
      .watch({
        destination: '/topic/' + this.chattopic,
      })
      .subscribe((newmessage) => [...this.messages, newmessage]);
  }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
    this.rxStomp.deactivate();
  }

  submitMessage() {
    this.chatmessage = {
      username: localStorage.getItem('username')
        ? localStorage.getItem('username')
        : null,
      messagebody: this.inputForm.controls['messagebody'].value,
    };
    this.rxStomp.publish({
      destination: '/topic/' + this.chattopic,
      body: JSON.stringify(this.chatmessage),
    });
  }
}
