import { Component, OnInit } from '@angular/core';
import {BloodBankService} from "../services/blood-bank.service";
import {Router} from "@angular/router";
export interface BloodBanks {
  bloodType: string;
  quantity:number;
  id:number

}
@Component({
  selector: 'app-blood-banks',
  templateUrl: './blood-banks.component.html',
  styleUrls: ['./blood-banks.component.css']
})
export class BloodBanksComponent implements OnInit {

  constructor(private bloodBankService: BloodBankService,private router:Router) { }
  bloodBanks:BloodBanks[]=[]
  displayedColumns: string[] = ['blood_type', 'quantity'];

  ngOnInit(): void {
    this.bloodBankService.getBloodBanks(1).subscribe(res=>{
      this.bloodBanks = res;
    })
  }

}
