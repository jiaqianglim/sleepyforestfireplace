import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Subject, takeUntil } from 'rxjs';
import { Topic } from 'src/app/model/topic';
import { LiveTopicService } from 'src/app/service/livetopic.service';

interface categoryoption {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit, OnDestroy {
  livetopics!: Topic[];
  chattopic = 'homepage';
  destroy$ = new Subject<void>();
  filterform!: FormGroup;
  opened!: boolean;

  categories: categoryoption[] = [
    { value: 'featured', viewValue: 'Featured' },
    { value: 'release_local', viewValue: 'Live Around You' },
    { value: 'release_news', viewValue: 'Live: World News' },
    { value: 'release_sports', viewValue: 'Live: Sports' },
    { value: 'release_tvshows', viewValue: 'Live: TV Episodes' },
    { value: 'release_politics', viewValue: 'Live: Government & Politics' },
  ];
  constructor(
    private livetopicservice: LiveTopicService,
    private http: HttpClient,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.livetopicservice
      .getLatestTopics()
      .pipe(takeUntil(this.destroy$))
      .subscribe((data) => {
        this.livetopics = data;
      });
    this.filterform = this.fb.group({
      queryString: this.fb.control<string>(''),
    });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  onProcessFilterForm() {}

  searchterm() {}
}
