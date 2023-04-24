import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { take, lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-topicform',
  templateUrl: './topicform.component.html',
  styleUrls: ['./topicform.component.css'],
})
export class TopicformComponent implements OnInit {
  maptabcount: number = 0;
  infotabcount: number = 0;
  picturegallerytabcount: number = 0;
  chatroomtabcount: number = 0;
  topicForm!: FormGroup;
  baseForm!: FormGroup;
  mapForm!: FormGroup;
  infoForm!: FormGroup;
  infoArray!: FormArray;
  infoFormGroup!: FormGroup;
  galleryForm!: FormGroup;
  galleryArray!: FormArray;
  galleryFormGroup!: FormGroup;
  discussionForm!: FormGroup;
  topicFormArray!: FormArray;
  topicTab!: FormArray;
  categories: string[] = [
    'Web-Streaming',
    'Local Events',
    'Locations',
    'Campaigns',
  ];
  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.topicFormArray = this.fb.array([]);
    this.topicForm = this.fb.group({ topics: this.topicFormArray });
    this.addbasetab();
  }

  addbasetab() {
    const baseForm = this.fb.group({
      tablabel: this.fb.control<string>('Info'),
      name: this.fb.control<string>('', Validators.required),
      category: this.fb.control<string>('', Validators.required),
      imagelink: this.fb.control<string>(''),
      description: this.fb.control<string>('', [
        Validators.maxLength(1000),
        Validators.required,
      ]),
      datestart: this.fb.control<string>('', [Validators.required]),
      datesend: this.fb.control<string>('', [Validators.required]),
    });
    this.topicFormArray.push(baseForm);
  }

  addmaptab() {
    this.maptabcount = this.maptabcount + 1;
    const mapgroup = this.fb.group({
      tablabel: this.fb.control('Map'),
      markerlabel: this.fb.control<string>('', Validators.required),
      lat: this.fb.control<number>(0, Validators.required),
      lng: this.fb.control<number>(0, Validators.required),
      locationdescription: this.fb.control<string>('', Validators.required),
    });
    this.topicFormArray.push(mapgroup);
  }
  addinformationtab() {
    this.infoArray = this.fb.array([]);
    const infoRow = this.fb.group({
      sectiontitle: this.fb.control<string>('', Validators.required),
      sectioncontent: this.fb.control<string>('', Validators.required),
    });
    this.infoArray.push(infoRow);
    this.topicFormArray.push(this.infoArray);
  }
  addinformationtabrow() {
    const infoRow = this.fb.group({
      sectiontitle: this.fb.control<string>('', Validators.required),
      sectioncontent: this.fb.control<string>('', Validators.required),
    });
    this.infoArray.push(infoRow);
    this.topicFormArray.push(this.infoArray);
  }
  addpicturegallerytab() {
    this.galleryArray = this.fb.array([]);
    const galleryRow = this.fb.group({
      imagelink: this.fb.control<string>(''),
    });
    this.galleryArray.push(galleryRow);
    this.topicFormArray.push(this.galleryArray);
  }
  addpicturegallerytabrow() {
    const galleryRow = this.fb.group({
      imagelink: this.fb.control<string>(''),
    });
    this.galleryArray.push(galleryRow);
    this.topicFormArray.push(this.galleryArray);
  }
  addchatroomtab() {
    const chatgroup = this.fb.group({
      tablabel: this.fb.control<string>('', Validators.required),
    });
  }

  processform() {
    const topicform = this.topicForm.value;
    const result$ = this.http
      .post<string>('/topic/new', topicform)
      .pipe(take(1));
    const topicid = lastValueFrom(result$)
      .then((data) => data)
      .catch((error) => console.log(error));
    this.router.navigate(['/topic', topicid]);
  }
}
