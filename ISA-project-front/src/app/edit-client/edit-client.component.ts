import { RegistrationService } from './../services/registration.service';
import { Component, OnInit } from '@angular/core';
import { RegClient } from '../model/regClient.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {
  public validEmail :any = 'OK';
  public validInfo : any = 'OK';
  public UpdateClient: RegClient=new RegClient();

  constructor(private registrationService:RegistrationService, private router: Router) { }
  ngOnInit(): void {
    this.registrationService.getClient("client@gmail.com").subscribe(res => {
      this.UpdateClient.password=res.password;
      this.UpdateClient.email=res.email;
      this.UpdateClient.firstName=res.firstName;
      this.UpdateClient.lastName=res.lastName;
      this.UpdateClient.phoneNumber=res.phoneNumber;
      this.UpdateClient.jmbg=res.jmbg;
      this.UpdateClient.gender=res.gender;
      this.UpdateClient.occupation=res.occupation;
      this.UpdateClient.organizationInformation=res.organizationInformation;
    })
  }
  Edit() {
    this.validationText();
    // if (!this.isValidInput()) {
    //   //alert("You must fill out all the fields")
    //   return;
    // }
    this.registrationService.updateClient(this.UpdateClient).subscribe(res => {
      alert("Registration request successfully sent!")
      this.router.navigate(['/']);
    });
        
    
  }
  
  private isValidInput(): boolean {
    return this.UpdateClient?.email != '' && this.UpdateClient?.firstName != '' && this.UpdateClient?.lastName != '' &&
    this.UpdateClient?.phoneNumber != ''  && this.UpdateClient?.jmbg != '' &&
    this.UpdateClient?.gender != '' && this.UpdateClient?.occupation != '' && this.UpdateClient?.organizationInformation != '';
  }

  private validationText(){
    if (this.UpdateClient?.email == '') {  this.validInfo = 'You must enter email'; return; }
    if (this.UpdateClient?.firstName == '') {this.validInfo = 'You must enter first name'; return;}
    if (this.UpdateClient?.lastName == '') {this.validInfo = 'You must enter last name'; return;}
    if (this.UpdateClient?.phoneNumber == '') {this.validInfo = 'You must enter phone number'; return;}
    if (this.UpdateClient?.jmbg == '') {this.validInfo = 'You must enter jmbg'; return;}
    if (this.UpdateClient?.gender == '') {this.validInfo = 'You must choose gender'; return;}
    if (this.UpdateClient?.occupation == '') {this.validInfo = 'You must enter occupation'; return;}
    if (this.UpdateClient?.organizationInformation == '') {this.validInfo = 'You must enter organization information'; return;}
  }

}
