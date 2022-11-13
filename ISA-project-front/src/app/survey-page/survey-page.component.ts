import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-survey-page',
  templateUrl: './survey-page.component.html',
  styleUrls: ['./survey-page.component.css']
})
export class SurveyPageComponent implements OnInit {

  public errorMess:String = 'OK';
  constructor() { }

  ngOnInit(): void {
  }
  sendSurvey(){
    alert('sub');
    var ele = document.getElementsByTagName('mat-radio-button');
    const a1 = document.getElementById("4") as HTMLInputElement;
    const a2 = document.getElementById("5") as HTMLInputElement;
    const a3 = document.getElementById("6") as HTMLInputElement;
    const a4 = document.getElementById("7") as HTMLInputElement;
    const a5 = document.getElementById("8") as HTMLInputElement;
    const a6 = document.getElementById("9") as HTMLInputElement;
    const a7 = document.getElementById("10") as HTMLInputElement;
    if(a1.checked){
      this.errorMess="... cant donate";
      alert('no')
      return;
    }else if(a2.checked){
      this.errorMess="... cant donate";
      return;
    }else if(a3.checked){
      this.errorMess="... cant donate";
      return;
    }else if(a4.checked){
      this.errorMess="... cant donate";
      return;
    }else if(a5.checked){
      this.errorMess="... cant donate";
      return;
    }else if(a6.checked){
      this.errorMess="... cant donate";
      return;
    }else if(a7.checked){
      this.errorMess="... cant donate";
      return;
    }

  }

}
