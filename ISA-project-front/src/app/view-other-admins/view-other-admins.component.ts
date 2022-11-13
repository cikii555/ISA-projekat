import { Component, OnInit } from '@angular/core';
import {TransfusionCenterServiceService} from "../services/transfusion-center-service.service";
import {Router} from "@angular/router";
import {IAdmin} from "../modelangular/admin";

@Component({
  selector: 'app-view-other-admins',
  templateUrl: './view-other-admins.component.html',
  styleUrls: ['./view-other-admins.component.css']
})
export class ViewOtherAdminsComponent implements OnInit {

  listAdmins:IAdmin[] = []
  constructor(private transfusionCenterService:TransfusionCenterServiceService,private router:Router) { }

  ngOnInit(): void {
    this.transfusionCenterService.getOtherCenterAdmins(1).subscribe(res => {
      this.listAdmins = res;
      console.log(this.listAdmins.length)
    })
  }

}
