import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { Time } from '@angular/common';
import { TransfusionCenterServiceService } from '../services/transfusion-center-service.service';
import {CenterService} from "../services/center.service";
import { AppointmentService } from '../services/appointment.service';



export class newAppointment {
  public startTime: Date = new Date; 
  public endTime: Date = new Date;
  public bloodTransfusionId: String = '';
};

@Component({
  selector: 'app-create-new-appointment',
  templateUrl: './create-new-appointment.component.html',
  styleUrls: ['./create-new-appointment.component.css']
})  

export class CreateNewAppointmentComponent implements OnInit {

  constructor(private transfusionCenterService:TransfusionCenterServiceService,private centerService:CenterService,private appointmentService:AppointmentService,private router:Router) { }

  public centerId: any;

  ngOnInit(): void {
    this.centerService.getBloodTransfusionCenterId().subscribe(res=>{
      this.centerId = res;})
  }

  public time:String="";
  public datepicker:Date=new Date();
  public dur:number=0;
  public Appointment:newAppointment=new newAppointment;

  Create(){
    var a=this.time.split(":")
    this.datepicker.setHours(parseInt(a[0]));
    const num2=+this.dur;
    this.datepicker.setMinutes(+a[1]);
    this.datepicker.setSeconds(0);

    this.Appointment.startTime=this.datepicker;
    var end=this.datepicker;
    end.setMinutes(parseInt(a[1])+num2);
    this.Appointment.endTime=end;
    this.Appointment.bloodTransfusionId=this.centerId;
    this.appointmentService.addAppointment(this.Appointment);
  }
}
  

