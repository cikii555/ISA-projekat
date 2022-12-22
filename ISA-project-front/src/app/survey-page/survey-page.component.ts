import { CenterService } from './../services/center.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-survey-page',
  templateUrl: './survey-page.component.html',
  styleUrls: ['./survey-page.component.css']
})
export class SurveyPageComponent implements OnInit {

  public errorMess:String = 'OK';
  public q4:any;
  public q5:any;
  public q6:any;
  public q7:any;
  public q8:any;
  public q9:any;
  public q10:any;
  public centerName:any;
  constructor(private route:ActivatedRoute, private router:Router, private centerService:CenterService) { }

  ngOnInit(): void {
    // this.route.params.subscribe((params: Params) => {
    //   this.centerName = params['id'];
    // })
  }
  sendSurvey(){
    if(this.q4 || this.q5 || this.q6 || this.q7 || this.q8 || this.q9 || this.q10){
      this.errorMess="You dont fill out the requirements to donate blood.";
      return;
    } else {
      this.errorMess = 'OK';
      // this.centerService.addAppointmentHistory(this.centerName).subscribe(res => {
      //   alert("Survey successfully sent!")
      //   this.router.navigate(['/home-client']);
      // });
      this.centerService.addSurvey().subscribe(res => {
        alert("Survey successfully sent!")
        this.router.navigate(['client/home']);
      });
    }

  }
  onQ4Change(v:any){
    if(v == '1')
      this.q4 = true;
    else this.q4 = false;
  }
  onQ5Change(v:any){
    if(v == '1')
      this.q5 = true;
    else this.q5 = false;
  }
  onQ6Change(v:any){
    if(v == '1')
      this.q6 = true;
    else this.q6 = false;
  }
  onQ7Change(v:any){
    if(v == '1')
      this.q7 = true;
    else this.q7 = false;
  }
  onQ8Change(v:any){
    if(v == '1')
      this.q8 = true;
    else this.q8 = false;
  }
  onQ9Change(v:any){
    if(v == '1')
      this.q9 = true;
    else this.q9 = false;
  }
  onQ10Change(v:any){
    if(v == '1')
      this.q10 = true;
    else this.q10 = false;
  }
  

}
