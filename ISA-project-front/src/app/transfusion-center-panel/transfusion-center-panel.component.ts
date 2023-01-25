import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {Router} from "@angular/router";
import {CenterService} from "../services/center.service";
@Component({
  selector: 'app-transfusion-center-panel',
  templateUrl: './transfusion-center-panel.component.html',
  styleUrls: ['./transfusion-center-panel.component.css']
})
export class TransfusionCenterPanelComponent implements OnInit {

  constructor(private router:Router,private centerService:CenterService) { }
  centerId:any
  ngOnInit(): void {
    this.centerService.getBloodTransfusionCenterId().subscribe(res=>{
      this.centerId = res
      console.log(this.centerId+"hahahhahahha")
    })
  }

  go(){
    this.router.navigateByUrl('/medicalstaff/tc/scheduled/'+this.centerId)
  }
}
