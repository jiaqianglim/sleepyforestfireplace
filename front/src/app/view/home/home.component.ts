import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { TopicCard } from 'src/app/model/topic';
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
  livetopics!: TopicCard[];
  chattopic = 'homepage';
  destroy$ = new Subject<void>();
  filterform!: FormGroup;
  opened!: boolean;

  categories: categoryoption[] = [
    { value: 'featured', viewValue: 'Featured' },
    { value: 'Web-Streaming', viewValue: 'Web-Streaming' },
    { value: 'Local Events', viewValue: 'Local Events' },
    { value: 'Locations', viewValue: 'Locations' },
    { value: 'Campaigns', viewValue: 'Campaigns' },
  ];
  constructor(
    private livetopicservice: LiveTopicService,
    private http: HttpClient,
    private fb: FormBuilder,
    private router: Router
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

  onProcessSimpleSearch() {
    this.router.navigate(['/search', this.filterform.value['querySting']]);
  }

  onProcessAdvancedSearch() {
    this.router.navigate(['/search', this.filterform.value['querySting']]);
  }

  gotofeaturedtopic() {
    this.router.navigate(['/featured']);
  }
}
