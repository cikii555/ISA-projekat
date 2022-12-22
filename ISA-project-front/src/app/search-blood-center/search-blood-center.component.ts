import { Component, OnInit } from '@angular/core';
import {TransfusionCenterServiceService} from "../services/transfusion-center-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search-blood-center',
  templateUrl: './search-blood-center.component.html',
  styleUrls: ['./search-blood-center.component.css']
})
export class SearchBloodCenterComponent implements OnInit {

  constructor(private router:Router,private bloodCenterService:TransfusionCenterServiceService) { }
  displayedColumns: string[] = ['name', 'address', 'rating'];
  dataSource :[]=[];
  public low:number=0;
  public high:number=5;
  ngOnInit(): void {
    this.bloodCenterService.getBloodTransfusionCenters().subscribe(res=>{
      this.dataSource = res
      console.log(this.dataSource)
    })
  }



}
