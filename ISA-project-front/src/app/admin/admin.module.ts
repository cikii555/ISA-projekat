import { AdminCenterDashboardComponent } from './../admin-center-dashboard/admin-center-dashboard.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { AuthorizationGuard } from '../login/authorization.guard';
import { RouterModule, Routes } from '@angular/router';
import { TransfusionCenterProfileComponent } from '../transfusion-center-profile/transfusion-center-profile.component';
import { ProfileAdminComponent } from '../profile-admin/profile-admin.component';
import { PasswordComponentComponent } from '../password-component/password-component.component';
import { EditProfileComponent } from '../edit-profile/edit-profile.component';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatSidenavModule } from '@angular/material/sidenav';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from '../app-routing.module';
import { MaterialModule } from '../material/material.module';
import { TransfusionCenterPanelComponent } from '../transfusion-center-panel/transfusion-center-panel.component';
import { ViewOtherAdminsComponent } from '../view-other-admins/view-other-admins.component';
import {BloodDonationAppointmentComponent} from "../blood-donation-appointment/blood-donation-appointment.component";
import {BloodBanksComponent} from "../blood-banks/blood-banks.component";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {SearchPatientAppointmentComponent} from "../search-patient-appointment/search-patient-appointment.component";
import {AppointmentPatientDetailsComponent} from "../appointment-patient-details/appointment-patient-details.component";

const routes: Routes = [
  {
    path: 'medical-staff',
    component: AdminComponent,
    data: {
      allowedRoles: ['MEDICALSTAFF']
    },
    canActivate:[AuthorizationGuard],
    children: [
        {path: 'admin-center-dashboard', component: AdminCenterDashboardComponent},
        {path:'centerprofile', component:TransfusionCenterProfileComponent},
        {path:'admincenter',component:ProfileAdminComponent,
          children: [
          {path: 'password',component: PasswordComponentComponent },
          {path: 'edit',component: EditProfileComponent}
        ]},
        {path:'tc',component:TransfusionCenterPanelComponent,children:[
          {path:'centerprofile', component:TransfusionCenterProfileComponent},
          {path:'admins', component:ViewOtherAdminsComponent},
            {path:'createappointment', component:BloodDonationAppointmentComponent},
            {path:'bloodbanks',component:BloodBanksComponent},
            {path:'scheduled',component: SearchPatientAppointmentComponent,children:[
                {path:'report/:id',component:BloodDonationAppointmentComponent},
                {path:'start/:id',component:AppointmentPatientDetailsComponent}
              ]}
        ]}
    ]
  }
]

@NgModule({
  declarations: [
    AdminComponent,
    AdminCenterDashboardComponent,
    TransfusionCenterProfileComponent,
    ProfileAdminComponent,
    PasswordComponentComponent,
    EditProfileComponent,
    TransfusionCenterPanelComponent,
    BloodBanksComponent,
    BloodDonationAppointmentComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    MatCardModule,
    MatSidenavModule,
    MatDividerModule,
    RouterModule.forChild(routes),
    MatDatepickerModule,
    ReactiveFormsModule,
  ]
})
export class AdminModule { }
