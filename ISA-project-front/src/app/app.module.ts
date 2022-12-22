import { SystemAdminModule } from './system-admin/system-admin.module';
import { AdminModule } from './admin/admin.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import {MatCardModule} from "@angular/material/card";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatDividerModule} from "@angular/material/divider";
import { AuthInterception } from './login/auth.interceptor';
import { ClientModule } from './client/client.module';
import { MatSortModule } from '@angular/material/sort';
import { SearchBloodCenterComponent } from './search-blood-center/search-blood-center.component';
import { SearchPatientAppointmentComponent } from './search-patient-appointment/search-patient-appointment.component';
import { BloodDonationReportComponent } from './blood-donation-report/blood-donation-report.component';
import { AppointmentPatientDetailsComponent } from './appointment-patient-details/appointment-patient-details.component';
import {MatCheckboxModule} from "@angular/material/checkbox";
import { CreateNewAppointmentComponent } from './create-new-appointment/create-new-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    SearchBloodCenterComponent,
    SearchPatientAppointmentComponent,
    BloodDonationReportComponent,
    AppointmentPatientDetailsComponent,
  ],

    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MaterialModule,
        FormsModule,
        HttpClientModule,
        MatCardModule,
        MatSidenavModule,
        MatDividerModule,
        ClientModule  ,
        AdminModule,
        SystemAdminModule,
        MatCheckboxModule,
        MatSortModule,
    ],



  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterception,
      multi: true
    }],




  bootstrap: [AppComponent]
})
export class AppModule { }
