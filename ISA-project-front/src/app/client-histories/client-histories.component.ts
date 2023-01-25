import { FutureAppointments } from './../model/future-appointments.model';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-client-histories',
  templateUrl: './client-histories.component.html',
  styleUrls: ['./client-histories.component.css']
})
export class ClientHistoriesComponent implements OnInit {

  public dataSource = new MatTableDataSource<FutureAppointments>();
  public displayedColumns = ['Starting', 'Ending', 'Blood transfusion center'];
  public appointments: FutureAppointments[] = [];
  public sortedData:any;
  constructor(private appointmentService:AppointmentService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.appointmentService.getAppointmentHistories().subscribe(res => {
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
}
