import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { topic } from '../model/topic';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
const WEBFLUX = environment.WEBFLUX;

@Injectable({
  providedIn: 'root',
})
export class LiveTopicService {
  constructor(private http: HttpClient) {}

  getLatestTopics(): Observable<topic[]> {
    return this.http.get<topic[]>(`${WEBFLUX}/livetopics`);
  }
}
