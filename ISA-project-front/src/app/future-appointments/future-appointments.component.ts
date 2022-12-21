import { FutureAppointments } from './../model/future-appointments.model';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-future-appointments',
  templateUrl: './future-appointments.component.html',
  styleUrls: ['./future-appointments.component.css']
})
export class FutureAppointmentsComponent implements OnInit {

  public dataSource = new MatTableDataSource<FutureAppointments>();
  public displayedColumns = ['Starting', 'Ending', 'Blood transfusion center', 'Cancel'];
  public futureAppointments: FutureAppointments[] = [];
  constructor(private appointmentService:AppointmentService, private router:Router) { }

  ngOnInit(): void {
    this.appointmentService.getFutureAppointments().subscribe(res => {
      this.futureAppointments = res;
      this.futureAppointments.forEach((app) => { 
        app.startTime = app.startTime.replace('T', ' ')
        app.endTime = app.endTime.replace('T',' ')
      })
      this.dataSource.data = this.futureAppointments;
    })
  }
  Cancel(id:any, app:any){
    const start = new Date(app.startTime.replace(' ', 'T'));
    const now = new Date()
    now.setDate(now.getDate() + 1);
    if(start <= now){
      alert("You cant cancel 24h before");
      return;
    }
    this.appointmentService.cancelAppointment(id).subscribe(res => {
      alert("Appointment successfully canceled!");
    });
  }

}
