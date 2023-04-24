import { Component, OnDestroy, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.css'],
})
export class TopicComponent implements OnInit, OnDestroy {
  constructor(private activatedRoute: ActivatedRoute, private title: Title) {}

  chattopic!: string;

  ngOnInit(): void {
    const topicname = this.activatedRoute.snapshot.params['topicname'];
    this.chattopic = topicname;
    this.title = topicname;
  }
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
}
