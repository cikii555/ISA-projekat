import { RegistrationService } from './../services/registration.service';
import { Component, OnInit } from '@angular/core';
import { RegClient } from '../model/regClient.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public registrationClient: RegClient = new RegClient();
  public passConfirm : String = '';
  public showPassword: boolean = false;
  public showPasswordConfirm: boolean = false;
  constructor(private registrationService:RegistrationService, private router: Router) { }

  ngOnInit(): void {
  }

  Registration() {
    if (!this.isValidInput()) {
      alert("You must fill out all the fields")
      return;
    }
    if(this.registrationClient.password!=this.passConfirm){
      alert("Passwords are not the same!")
      return;
    }
    this.registrationService.registerUser(this.registrationClient).subscribe(res => {
      alert("Registration request successfully sent!")
      this.router.navigate(['/']);
    });
    }
    public togglePasswordVisibility(): void {
      this.showPassword = !this.showPassword;
    }
    public togglePasswordConfirmVisibility(): void {
      this.showPasswordConfirm = !this.showPasswordConfirm;
    }
  private isValidInput(): boolean {
    return this.registrationClient?.email != '' && this.registrationClient?.password !='' && this.registrationClient?.firstName != '' && this.registrationClient?.lastName != '' &&
    this.registrationClient?.phoneNumber != '' && this.registrationClient?.country != '' && this.registrationClient?.city != '' &&
    this.registrationClient?.street != '' && this.registrationClient?.streetNumber != '' && this.registrationClient?.jmbg != '' &&
    this.registrationClient?.gender != '' && this.registrationClient?.occupation != '' && this.registrationClient?.organizationInformation != '';
  }
}
