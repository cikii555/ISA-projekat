import { Component, OnInit } from '@angular/core';
import {MedicalStaffServiceService} from "../services/medical-staff-service.service";
import {Password} from "../model/password.model";

@Component({
  selector: 'app-password-component',
  templateUrl: './password-component.component.html',
  styleUrls: ['./password-component.component.css']
})
export class PasswordComponentComponent implements OnInit {

  constructor(private medicalStaffService:MedicalStaffServiceService) { }
   PasswordDTO={
    oldPassword:'',
     newPassword:'',
     id:1
  }

  ngOnInit(): void {
  }

  changePassword(){
    console.log(this.PasswordDTO.oldPassword)
    console.log(this.PasswordDTO.newPassword)
    this.medicalStaffService.changePasswordAdminCenter(this.PasswordDTO)
  }

}
