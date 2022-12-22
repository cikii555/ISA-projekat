import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MatDatepickerModule} from '@angular/material/datepicker';



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

  constructor() { }
  
  ngOnInit(): void {
    
  }
  public pick:Date=new Date();
  public dur:number=0;
  public Appointment:newAppointment=new newAppointment;

  Create(){

    }
}
  

