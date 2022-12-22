import { Component, OnInit } from '@angular/core';
enum BloodTypes {
  A_POS,
  A_NEG,
  B_POS,
  B_NEG,
  AB_POS,
  AB_NEG,
  O_POS,
  O_NEG
}
@Component({
  selector: 'app-blood-donation-report',
  templateUrl: './blood-donation-report.component.html',
  styleUrls: ['./blood-donation-report.component.css']
})
export class BloodDonationReportComponent implements OnInit {
  option:any
  blood =[BloodTypes.O_NEG,BloodTypes.O_POS,BloodTypes.A_NEG,BloodTypes.A_POS,BloodTypes.AB_NEG,BloodTypes.AB_POS,BloodTypes.B_POS,BloodTypes.B_NEG]
  report={
    bloodType:'',
    quantity:0,
    equipment:'',
    equantity:0

  }
  constructor() { }
  getOptionLabel(option: BloodTypes) {
    switch (option) {
      case BloodTypes.A_POS:
        return "A+";
      case BloodTypes.A_NEG:
        return "A-";
      case BloodTypes.B_NEG:
        return "B-";
      case BloodTypes.B_POS:
        return "B+";
      case BloodTypes.AB_POS:
        return "AB+";
      case BloodTypes.AB_NEG:
        return "AB-";
      case BloodTypes.O_NEG:
        return "O-";
      case BloodTypes.O_POS:
        return "O+";
      default:
        throw new Error("Unsupported option");
    }
  }
  ngOnInit(): void {
  }
  changedBloodType(type:any){

  }
  addNewReport(){

  }


}
