import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { TransfusionCenterServiceService } from '../services/transfusion-center-service.service';



export class newAppointment {
  public startTime: Date = new Date; 
  public endTime: Date = new Date;
  public BloodBankName: String = '';
}

@Component({
  selector: 'app-create-new-appointment',
  templateUrl: './create-new-appointment.component.html',
  styleUrls: ['./create-new-appointment.component.css']
})  

export class CreateNewAppointmentComponent implements OnInit {

  constructor(private transfusionCenterService:TransfusionCenterServiceService,private router:Router) { }
  
  ngOnInit(): void {
    
  }
  public time:String="";
  public datepicker:Date=new Date();
  public dur:number=0;
  public Appointment:newAppointment=new newAppointment;

  async Create(){
    var a=this.time.split(":")
    this.datepicker.setHours(parseInt(a[0]));
    const num2=+this.dur;
    this.datepicker.setMinutes(+a[1]);
    this.datepicker.setSeconds(0);

    this.Appointment.startTime=this.datepicker;
    var end=this.datepicker;
    end.setMinutes(parseInt(a[1])+num2);
    this.Appointment.endTime=end;
    this.Appointment.BloodBankName="ISA-HOSPITAL";
    // var name=await this.transfusionCenterService.getByCenterAdmin();
    // alert(name.name);
  }
}
  

