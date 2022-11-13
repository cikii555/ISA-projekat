import { Component, OnInit } from '@angular/core';
import {MedicalStaffServiceService} from "../services/medical-staff-service.service";

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  selectedAdmin:any
  constructor(private medicalStaffService:MedicalStaffServiceService) { }

  ngOnInit(): void {
    this.medicalStaffService.getCenterAdmin(1).subscribe(res=>{
      this.selectedAdmin = res;
    })
  }

  updateAdminProfile(){
    this.medicalStaffService.updateCenterAdmin(this.selectedAdmin)
  }
}
