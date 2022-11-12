import { Component, OnInit } from '@angular/core';
import {TransfusionCenterServiceService} from "../services/transfusion-center-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-transfusion-center-profile',
  templateUrl: './transfusion-center-profile.component.html',
  styleUrls: ['./transfusion-center-profile.component.css']
})
export class TransfusionCenterProfileComponent implements OnInit {

  selectedCenter:any
  constructor(private transfusionCenterService:TransfusionCenterServiceService,private router:Router) { }

  ngOnInit(): void {
    this.transfusionCenterService.getBloodTransfusionCenter(1).subscribe(res=>{
      this.selectedCenter = res;
    })

  }

}
