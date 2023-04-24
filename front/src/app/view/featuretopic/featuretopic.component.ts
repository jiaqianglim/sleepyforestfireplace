import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { mapcords } from 'src/app/model/mapcords';

@Component({
  selector: 'app-featuretopic',
  templateUrl: './featuretopic.component.html',
  styleUrls: ['./featuretopic.component.css'],
})
export class FeaturetopicComponent implements OnInit {
  constructor(private http: HttpClient) {}
  chattopic!: string;
  coordinates!: mapcords;
  locationname!: string;
  locationdescription!: string;

  ngOnInit(): void {
    this.locationname = 'esplanade';
    this.locationdescription = "Singapore's premier arts venue";
    this.coordinates = { lat: 1.289868732632052, lng: 103.85580924917289 };
  }
}
