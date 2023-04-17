import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Topic } from '../model/topic';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
const WEBFLUX = environment.WEBFLUX;

@Injectable({
  providedIn: 'root',
})
export class LiveTopicService {
  constructor(private http: HttpClient) {}

  getLatestTopics(): Observable<Topic[]> {
    return this.http.get<Topic[]>(`${WEBFLUX}/livetopics`);
  }
}
