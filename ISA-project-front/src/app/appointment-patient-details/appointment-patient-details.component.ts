import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {AppointmentService} from "../services/appointment.service";
export interface IAppointmentHistory{
  appointmentId:number,
  bloodCenterName:string,
  clientId:number,
  endTime:any,
  historyId:number,
  patientName:string,
  patientSurname:string,
  startTime:any

}
@Component({
  selector: 'app-appointment-patient-details',
  templateUrl: './appointment-patient-details.component.html',
  styleUrls: ['./appointment-patient-details.component.css']
})

export class AppointmentPatientDetailsComponent implements OnInit {

  constructor(private router:Router,private appointmentService:AppointmentService,private route:ActivatedRoute) { }
  appointment:any

  centerId:any
  historyId:any
  checked = false;
  client:any
  appointmentHistory:any
  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.appointmentService.getAppointmentHistory(params['id']).subscribe( res => {

        this.appointmentHistory = res;
       this.client = this.appointmentHistory.clientId
        this.appointmentService.canClientDonateBlood(this.client).subscribe(res=>{
          this.checked =res

        })
      });

      this.centerId =params['id']
      this.historyId = params['ids']

    })

  }
  goToReportPage(){
    this.router.navigate(['./report/'+this.historyId], {relativeTo: this.route});
  }

  goToList(){
    //this.router.navigate(['/scheduled/'+this.centerId],{relativeTo: this.route})
  }

  onChecked(e:any){

    if(e.target.checked){
      //  check box Checked
      this.appointmentService.didntShowUp(this.client)
    }else{
      //  check box unChecked
    }

  }

}
