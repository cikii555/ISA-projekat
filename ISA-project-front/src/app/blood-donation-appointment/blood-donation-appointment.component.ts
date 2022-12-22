import { Component, OnInit } from '@angular/core';
import {MedicalStaffServiceService} from "../services/medical-staff-service.service";
import {Router} from "@angular/router";
import {MedicalStaff} from "../model/medical-staff.model";
import {FormControl} from "@angular/forms";
import {BloodDonationAppointmentService} from "../services/blood-donation-appointment.service";


interface Appointment {
  value: string;
  viewValue: string;
}
export interface NewAppointment{
  date: any;
  starttime:any;
  endtime:any;
  staff:any
}

@Component({
  selector: 'app-blood-donation-appointment',
  templateUrl: './blood-donation-appointment.component.html',
  styleUrls: ['./blood-donation-appointment.component.css']
})
export class BloodDonationAppointmentComponent implements OnInit {

  constructor( private medicalStaffService:MedicalStaffServiceService,private router:Router, private bloodAppointment:BloodDonationAppointmentService) { }
  medicalStaff:MedicalStaff[]=[]
  id:number
  time:any
  date = new FormControl(new Date());

   newapp: NewAppointment = {
    date: '',
    starttime: '',
     endtime:'',
    staff :[]

}
  medicalStaffSelected = new FormControl('');
  appointments: Appointment[]  = [
    {value: '8:00-9:00', viewValue: '8:00-9:00'},
    {value: '9:00-10:00', viewValue: '9:00-10:00'},
    {value: '10:00-11:00', viewValue: '10:00-11:00'},
    {value: '11:00-12:00', viewValue: '11:00-12:00'},
    {value: '12:00-13:00', viewValue: '12:00-13:00'},
    {value: '13:00-14:00', viewValue: '13:00-14:00'},
  ];

  ngOnInit(): void {

    this.medicalStaffService.getMedicalStaff(1).subscribe(res=>{
      this.medicalStaff = res;
      console.log(this.medicalStaffSelected.value)
      this.medicalStaffSelected.valueChanges.subscribe(data => console.log(data));
    })
    console.log(this.medicalStaffSelected.value)

  }
pickedTime(event:any){
  console.log(event.source.value)
  this.time = (event.source.value).split('-')
  console.log(this.time)
}
AddNewAppointment(){
  this.newapp.staff = this.medicalStaffSelected.value
  let stringified = JSON.stringify(this.newapp.date);
  console.log(stringified)
  stringified = stringified.split('T')[0]+'"';
  console.log(stringified)
  //console.log(this.newapp.startime)
  this.newapp.date = stringified
  var time_t = "09:56 AM" ;
  var dt = new Date(stringified+this.time[0]);
  var dte = new Date(stringified+this.time[1])

  console.log(dt);
  console.log(dte);
  this.newapp.starttime = dt
  this.newapp.endtime = dte

  this.medicalStaffSelected.valueChanges.subscribe(data => this.newapp.staff = data);
  console.log(this.newapp.staff)
  this.bloodAppointment.addNewAppointment(this.newapp).subscribe()
}

}
