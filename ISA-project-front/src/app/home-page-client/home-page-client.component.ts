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
  public search:string='';
  public searchOption:string='NAME';
  public base:TransfusionCenter[]=[];
  public low:number=0;
  public high:number=5;


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
  }
  key = 'id';
  reverse:boolean = false;
  sort(key:any){
    this.key = key;
    this.reverse = !this.reverse;

  }
  survey(center:any){
    this.router.navigate(['client/survey/' + center.name]);
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

  
}
