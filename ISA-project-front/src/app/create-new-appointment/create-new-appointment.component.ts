import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { TransfusionCenterServiceService } from '../services/transfusion-center-service.service';
import {CenterService} from "../services/center.service";
import { AppointmentService } from '../services/appointment.service';



export class newAppointment {
  public startDate: Date = new Date; 
  public endDate: Date = new Date;
  public bloodTransfusionId: String = '';
  public duration:number;
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
      this.centerId = 1;})
  }

  public time:String="";
  public datepicker:Date=new Date();
  public dur:number=0;
  public Appointment:newAppointment=new newAppointment;

  Create(){
    var a=this.time.split(":")
    this.datepicker.setHours(parseInt(a[0]));
    this.Appointment.duration=+this.dur;
    this.datepicker.setMinutes(+a[1]);
    this.datepicker.setSeconds(0);

    this.Appointment.startDate=this.datepicker;

    this.Appointment.bloodTransfusionId="1";
    this.appointmentService.addAppointment(this.Appointment).subscribe(res =>{this.router.navigateByUrl('medical-staff/admin-center-dashboard');})
  }
};
  

