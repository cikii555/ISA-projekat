import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {AppointmentService} from "../services/appointment.service";

@Component({
  selector: 'app-appointment-patient-details',
  templateUrl: './appointment-patient-details.component.html',
  styleUrls: ['./appointment-patient-details.component.css']
})
export class AppointmentPatientDetailsComponent implements OnInit {

  constructor(private router:Router,private appointmentService:AppointmentService,private route:ActivatedRoute) { }
  appointment:any
  data:any
  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.appointmentService.getAppointmentHistory(params['id']).subscribe( res => {
        this.data = res;
      });
    })
  }
  goToReportPage(){
    this.router.navigateByUrl('/report')
  }

  onChecked(e:any){

    if(e.target.checked){
      //  check box Checked
    }else{
      //  check box unChecked
    }

  }

}
