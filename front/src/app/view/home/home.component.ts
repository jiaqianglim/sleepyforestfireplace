import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject, takeUntil } from 'rxjs';
import { Topic } from 'src/app/model/topic';
import { LiveTopicService } from 'src/app/service/livetopic.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit, OnDestroy {
  livetopics!: Topic[];
  destroy$ = new Subject<void>();

  constructor(private livetopicservice: LiveTopicService) {}

  ngOnInit(): void {
    this.livetopicservice
      .getLatestTopics()
      .pipe(takeUntil(this.destroy$))
      .subscribe((data) => {
        this.livetopics = data;
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
