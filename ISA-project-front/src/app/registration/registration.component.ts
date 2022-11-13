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

  public byEmail : any;
  public validEmail :any = 'OK';
  public validInfo : any = 'OK';
  public registrationClient: RegClient = new RegClient();
  public passConfirm : String = '';
  public showPassword: boolean = false;
  public showPasswordConfirm: boolean = false;
  constructor(private registrationService:RegistrationService, private router: Router) { }

  ngOnInit(): void {
  }

  Registration() {
    this.validationText();
    this.registrationService.getClient(this.registrationClient?.email).subscribe(res => {
      this.byEmail = res; 
      if(this.byEmail != null){
        this.validEmail='Email is already taken';
      }else{
        if (!this.isValidInput()) {
          //alert("You must fill out all the fields")
          return;
        }
        if(this.registrationClient.password!=this.passConfirm){
          //alert("Passwords are not the same!")
          return;
        }
        this.registrationService.registerUser(this.registrationClient).subscribe(res => {
          alert("Registration request successfully sent!")
          this.router.navigate(['/home-client']);
        });
        }
    })
   
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
  private validationText(){
    if (this.registrationClient?.email == '') {  this.validInfo = 'You must enter email'; return; }
   if (this.registrationClient?.password =='') { this.validInfo = 'You must enter password'; return;}
   if (this.passConfirm == '') {this.validInfo = 'You must reenter your password'; return;}
   if (this.registrationClient?.password != this.passConfirm) {this.validInfo = 'Passwords are not the same'; return;}
   if (this.registrationClient?.firstName == '') {this.validInfo = 'You must enter first name'; return;}
   if (this.registrationClient?.lastName == '') {this.validInfo = 'You must enter last name'; return;}
   if (this.registrationClient?.country == '' || this.registrationClient?.city == '' ||
   this.registrationClient?.street == '' || this.registrationClient?.streetNumber == '') {this.validInfo = 'You must enter address'; return;}
   if (this.registrationClient?.phoneNumber == '') {this.validInfo = 'You must enter phone number'; return;}
   if (this.registrationClient?.jmbg == '') {this.validInfo = 'You must enter jmbg'; return;}
   if (this.registrationClient?.gender == '') {this.validInfo = 'You must choose gender'; return;}
   if (this.registrationClient?.occupation == '') {this.validInfo = 'You must enter occupation'; return;}
   if (this.registrationClient?.organizationInformation == '') {this.validInfo = 'You must enter organization information'; return;}
   
  }
}
