import { Component, Input, OnInit } from '@angular/core';
import { mapcords } from 'src/app/model/mapcords';

@Component({
  selector: 'app-googlemap',
  templateUrl: './googlemap.component.html',
  styleUrls: ['./googlemap.component.css'],
})
export class GooglemapComponent implements OnInit {
  @Input() coordinates!: mapcords;
  @Input() locationname!: string;

  ngOnInit(): void {
    let map;
    this.initmap();
  }

  async initmap(): Promise<void> {
    let map;
    //@ts-ignore
    const { Map } = await google.maps.importLibrary('maps');
    //@ts-ignore
    const { AdvancedMarkerView } = await google.maps.importLibrary('marker');
    map = new Map(document.getElementById('map') as HTMLElement, {
      zoom: 4,
      center: this.coordinates,
      mapId: 'DEMO_MAP_ID',
    });

    const marker = new AdvancedMarkerView({
      map: map,
      position: this.coordinates,
      title: this.locationname,
    });
  }
}
