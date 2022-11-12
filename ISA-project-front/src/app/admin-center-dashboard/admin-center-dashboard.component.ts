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
this.router.navigateByUrl('centerprofile')
}
goToNewAppointment(){

}
goToProfile(){
this.router.navigateByUrl('/admincenter')
}

}
