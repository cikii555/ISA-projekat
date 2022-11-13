import { Router } from '@angular/router';
import { TransfusionCenter } from './../model/transfusionCenter.model';
import { CenterService } from './../services/center.service';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';


@Component({
  selector: 'app-home-page-client',
  templateUrl: './home-page-client.component.html',
  styleUrls: ['./home-page-client.component.css']
})
export class HomePageClientComponent implements OnInit {

  public dataSource = new MatTableDataSource<TransfusionCenter>();
  public sortedData:any;
  public centers: TransfusionCenter[] = [];
  displayedColumns: string[] = ['Name','Street and number', 'City', 'Country', 'Discription', 'Average grade', 'Work hours'];
  // @ViewChild('empTbSort') empTbSort = new MatSort();
  //@ViewChild(MatSort) sort: MatSort;
  constructor(private _liveAnnouncer: LiveAnnouncer, private centerService: CenterService, private router:Router) {
  }

  ngOnInit(): void {
    this.centerService.getCenters().subscribe(res => {
      this.centers = res;
      this.dataSource = new MatTableDataSource(this.centers);
      //this.dataSource.data = this.centers;
    })
  }
  key = 'id';
  reverse:boolean = false;
  sort(key:any){
    this.key = key;
    this.reverse = !this.reverse;

  }
  survey(center:any){
    this.router.navigate(['survey/' + center.name]);
  }

  
}
