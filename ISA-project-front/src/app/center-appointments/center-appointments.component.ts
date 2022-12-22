import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Appointment } from '../model/center-appointment.model';
import { AppointmentService } from '../services/appointment.service';
import {MatSort, Sort} from '@angular/material/sort';

@Component({
  selector: 'app-center-appointments',
  templateUrl: './center-appointments.component.html',
  styleUrls: ['./center-appointments.component.css']
})
export class CenterAppointmentsComponent implements OnInit {

  public dataSource = new MatTableDataSource<Appointment>();
  public displayedColumns = ['Starting', 'Ending', 'TakeAppointment'];
  public appointments: Appointment[] = [];
  public centerName:any;
  public canDonate: boolean;
  public sortedData:any;
  constructor(private appointmentService:AppointmentService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
     this.route.params.subscribe((params: Params) => {
       this.centerName = params['id'];
     })
    this.appointmentService.getCenterAppointments(this.centerName).subscribe(res => {
      this.appointments = res;
      this.appointments.forEach((app) => { 
        app.startTime = app.startTime.replace('T', ' ')
        app.endTime = app.endTime.replace('T',' ')
      })
      this.dataSource.data = this.appointments;
    })
  }
  key = 'id';
  reverse:boolean = false;
  sort(key:any){
    this.key = key;
    this.reverse = !this.reverse;

  }

  TakeAppointment(id:any){
    this.appointmentService.canDonate().subscribe(res => {
      this.canDonate = res;
      if(this.canDonate==false){
        alert("You dont fill out the requirements to donate blood.");
        return;
      }
      this.appointmentService.takeAppointment(id).subscribe(res => {
        alert("Appointment successfully scheduled!");
        this.router.navigate(['client/home']);
      });
    })
  }
}
