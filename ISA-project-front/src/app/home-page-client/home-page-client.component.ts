import { Router } from '@angular/router';
import { TransfusionCenter } from './../model/transfusionCenter.model';
import { CenterService } from './../services/center.service';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import * as ol from 'ol';
import {Map} from 'ol';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import {transform} from 'ol/proj.js';
import Vector from 'ol/layer/Vector';
import SourceVector from 'ol/source/Vector';
import Style from 'ol/style/Style';
import Icon from 'ol/style/Icon';
import { Point } from 'ol/geom';


@Component({
  selector: 'app-home-page-client',
  templateUrl: './home-page-client.component.html',
  styleUrls: ['./home-page-client.component.css']
})
export class HomePageClientComponent implements OnInit {

  public dataSource = new MatTableDataSource<TransfusionCenter>();
  public sortedData:any;
  public search:string='';
  public searchOption:string='NAME';
  public base:TransfusionCenter[]=[];
  public low:number=0;
  public high:number=5;
  map: Map;


  public centers: TransfusionCenter[] = [];
  displayedColumns: string[] = ['Name','Street and number', 'City', 'Country', 'Discription', 'Average grade', 'Work hours'];
  // @ViewChild('empTbSort') empTbSort = new MatSort();
  //@ViewChild(MatSort) sort: MatSort;
  constructor(private _liveAnnouncer: LiveAnnouncer, private centerService: CenterService, private router:Router) {
  }

  ngOnInit(): void {
    this.centerService.getCenters().subscribe(res => {
      this.centers = res;
      this.base=res;
      this.dataSource = new MatTableDataSource(this.centers);
      //this.dataSource.data = this.centers;
    })
    this.map = new Map({
      view: new ol.View({
        center: transform([19.833549,45.267136], 'EPSG:4326', 'EPSG:3857'),
        zoom: 15,
      }),
      layers: [
        new TileLayer({
          source: new OSM(),
        }),
      ],
      target: 'map'
    });
  }
  key = 'id';
  reverse:boolean = false;
  sort(key:any){
    this.key = key;
    this.reverse = !this.reverse;

  }
  Appointments(center:any){
    this.router.navigate(['client/appointments/' + center.name]);
  }
  searchItems(Search:string){
    if(Search===null)
    return
    if(Search.length==0)
    this.centerService.getCenters().subscribe(res => {
      this.centers = res;
      this.base=res;

    })
    if(this.searchOption==='NAME')
    this.centerService.searchCentersByName(Search).subscribe(res => {
      this.centers = res;
      this.base=res;
      this.dataSource = new MatTableDataSource(this.centers);

    })
    else if(this.searchOption==='CITY')
    this.centerService.searchCentersByCityName(Search).subscribe(res => {
      this.centers = res;
      this.base=res;
      this.dataSource = new MatTableDataSource(this.centers);

    })
  }
  FilterItems(){
    if (this.high<this.low ||this.low<0 || this.high<0||this.high>5)
    return;

    this.centers=[]
    let a=0;
    for(let i=0;i<this.base.length;i++){
      if(this.base[i].averageGrade>=this.low)
        if(this.base[i].averageGrade<=this.high)
        this.centers.push(this.base[i]);
    }
    
  }
  ShowOnMap(center:any){
    const markerSource = new SourceVector();
    var markerStyle = new Style({
      image: new Icon(/** @type {olx.style.IconOptions} */ ({
        anchor: [0.5, 46],
        anchorXUnits: 'fraction',
        anchorYUnits: 'pixels',
        opacity: 0.75,
        src: 'https://openlayers.org/en/v4.6.4/examples/data/icon.png'
      }))
    });
    var markers = new Vector({
      source: markerSource,
      style: markerStyle
    });
    this.map.addLayer(markers);
    var marker = new ol.Feature(new Point(transform([19.833549,45.267136], 'EPSG:4326', 'EPSG:3857')));
    markers.getSource()?.addFeature(marker); 
  }

  
}
