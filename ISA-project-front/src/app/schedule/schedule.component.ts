import { Component, OnInit } from '@angular/core';
import { NewAppointment } from '../blood-donation-appointment/blood-donation-appointment.component';
import { Router } from '@angular/router';
import { TransfusionCenterServiceService } from '../services/transfusion-center-service.service';
import {CenterService} from "../services/center.service";
import { AppointmentService } from '../services/appointment.service';


export class prezAppointment {
  public startDate: String = ""; 
  public endDate: String = "";
  public taken:boolean;
};
@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  constructor(private transfusionCenterService:TransfusionCenterServiceService,private centerService:CenterService,private appointmentService:AppointmentService,private router:Router) {
    
   }
  public centerId: number;
  public schedule:prezAppointment[];

  ngOnInit(): void {
    this.centerService.getBloodTransfusionCenterId().subscribe(res=>{
      this.centerId = res;
      this.appointmentService.getAppointmensByCenter(this.centerId).subscribe(res=>{
        this.schedule=res;
     });
       
  })
}

}
