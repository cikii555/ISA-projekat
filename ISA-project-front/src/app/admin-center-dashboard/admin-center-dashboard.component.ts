import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-admin-center-dashboard',
  templateUrl: './admin-center-dashboard.component.html',
  styleUrls: ['./admin-center-dashboard.component.css']
})
export class AdminCenterDashboardComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
goToTCPage(){
this.router.navigateByUrl('medical-staff/tc')
}
goToNewAppointment(){
this.router.navigateByUrl('createappointment')
}
goToSchedule(){
  this.router.navigateByUrl('medical-staff/schedule');
}
goToNewAppointmentSlot(){
this.router.navigateByUrl('medical-staff/nesto');
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
