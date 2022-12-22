import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {BloodDonationAppointmentService} from "../services/blood-donation-appointment.service";
import {MatTableDataSource} from "@angular/material/table";
import {AppointmentService} from "../services/appointment.service";
import {TransfusionCenter} from "../model/transfusionCenter.model";
import {CenterService} from "../services/center.service";

@Component({
  selector: 'app-search-patient-appointment',
  templateUrl: './search-patient-appointment.component.html',
  styleUrls: ['./search-patient-appointment.component.css']
})
export class SearchPatientAppointmentComponent implements OnInit {

  constructor(private router:Router,private appointmentService: BloodDonationAppointmentService,private appService:AppointmentService,private centerService:CenterService)
    { }
  displayedColumns: string[] = ['name', 'surname', 'date', 'time'];
  dataSource = new MatTableDataSource<any>();
  centerId:any
  public search:string='';
  public searchOption:string='NAME';
  public base:any
  public appointments:any
  ngOnInit(): void {

    this.appointmentService.getScheduledAppointments(this.centerId).subscribe(res=>{
      this.dataSource = res
    })
    this.centerService.getBloodTransfusionCenterId().subscribe(res=>{
      this.centerId = res
      console.log(this.centerId+"hahahhahahha")
    })
  }

  StartAppointment(row:any){
    console.log(row)
    this.router.navigateByUrl('/start/'+row.id)
  }
  searchItems(Search:string){
    if(Search===null)
      return
    if(Search.length==0)
      this.appointmentService.getScheduledAppointments(this.centerId).subscribe(res => {
        this.appointments = res;
        this.base=res;

      })
    if(this.searchOption==='NAME')
      this.appService.searchAppointmentsByName(Search).subscribe(res => {
        this.appointments = res;
        this.base=res;
        this.dataSource = new MatTableDataSource(this.appointments)

      })
    else if(this.searchOption==='SURNAME')
      this.appService.searchAppointmentsBySurname(Search).subscribe(res => {
        this.appointments = res;
        this.base=res;
        this.dataSource = new MatTableDataSource(this.appointments)

      })
  }

}
