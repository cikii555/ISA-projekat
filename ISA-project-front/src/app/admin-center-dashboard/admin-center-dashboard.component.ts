import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AppointmentService} from "../services/appointment.service";
import {CenterService} from "../services/center.service";
@Component({
  selector: 'app-admin-center-dashboard',
  templateUrl: './admin-center-dashboard.component.html',
  styleUrls: ['./admin-center-dashboard.component.css']
})
export class AdminCenterDashboardComponent implements OnInit {

  constructor(private router: Router,private appointmentService:AppointmentService,private centerService:CenterService) { }
  centerId:any
  ngOnInit(): void {
    this.centerService.getBloodTransfusionCenterId().subscribe(res=>{
      this.centerId = res
      console.log(this.centerId+"hahahhahahha")
    })
  }
goToTCPage(){
this.router.navigateByUrl('medical-staff/tc')
}
goToNewAppointment(){
this.router.navigateByUrl('createappointment')
}
goToProfile(){
this.router.navigateByUrl('medical-staff/admincenter')
}

goToScheduledAppointments(){
    this.router.navigateByUrl('scheduled')
}
LogOut(){
  localStorage.removeItem('token');
  localStorage.removeItem('role');
  this.router.navigate(["/"]);
}

}
