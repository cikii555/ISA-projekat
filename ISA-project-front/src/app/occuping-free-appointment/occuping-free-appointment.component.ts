import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { TransfusionCenter } from '../model/transfusionCenter.model';
import { CenterService } from '../services/center.service';
import { newAppointment } from '../create-new-appointment/create-new-appointment.component';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-occuping-free-appointment',
  templateUrl: './occuping-free-appointment.component.html',
  styleUrls: ['./occuping-free-appointment.component.css']
})
export class OccupingFreeAppointmentComponent implements OnInit {
  public centers: TransfusionCenter[] = [];
  displayedColumns: string[] = ['Name','Street and number', 'City', 'Country', 'Discription', 'Average grade', 'Work hours'];
  
  constructor( private appointmentService:AppointmentService,private centerService: CenterService, private router:Router) { }
  
  ngOnInit(): void {
    this.centerService.getCenters().subscribe(res => {
      this.centers = res;
      //this.dataSource.data = this.centers;
    })
  }
  public datepicker:Date=new Date();
  public pick:Date=new Date();
  public time:String="";
  public Appointment:newAppointment=new newAppointment;
  public show:boolean=false;
  public show2:boolean=false;

  key = 'id';
  reverse:boolean = false;
  sort(key:any){
    this.key = key;
    this.reverse = !this.reverse;

  }
  find(){
    var a=this.time.split(":")
    this.pick.setHours(parseInt(a[0])+1);
    this.pick.setMinutes(+a[1]);
    this.appointmentService.getBanks(this.pick).subscribe(res=>{this.centers=res;
      if(this.centers.length!=0) this.show=true; else this.show2=true;});
  }
  reserve(name:String){
    var id:number;
    this.appointmentService.getAppointmentID(this.pick,name).subscribe(res=>{
      id=res;
      this.appointmentService.scheduleAppointment(id).subscribe(
        moc=>{this.appointmentService.sendEmail(id,name).subscribe(res=>{this.router.navigateByUrl('client/home');})});
    })
  }
}
