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
import {FormsModule} from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import { ProfileAdminComponent } from './profile-admin/profile-admin.component';
import { TransfusionCenterProfileComponent } from './transfusion-center-profile/transfusion-center-profile.component';
import {MatCardModule} from "@angular/material/card";
import { AdminCenterDashboardComponent } from './admin-center-dashboard/admin-center-dashboard.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { PasswordComponentComponent } from './password-component/password-component.component';
import {MatDividerModule} from "@angular/material/divider";
import { ViewOtherAdminsComponent } from './view-other-admins/view-other-admins.component';
import { SurveyPageComponent } from './survey-page/survey-page.component';
import { EditClientComponent } from './edit-client/edit-client.component';
import { HomePageClientComponent } from './home-page-client/home-page-client.component';
import { TransfusionCenterPanelComponent } from './transfusion-center-panel/transfusion-center-panel.component';
import { AuthInterception } from './login/auth.interceptor';
import { ClientComponent } from './client/client.component';
import { AdminComponent } from './admin/admin.component';
import { ClientModule } from './client/client.module';
import { FutureAppointmentsComponent } from './future-appointments/future-appointments.component';
import { MatSortModule } from '@angular/material/sort';
import { CreateNewAppointmentComponent } from './create-new-appointment/create-new-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    CreateNewAppointmentComponent,

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
    ClientModule,
    AdminModule,
    SystemAdminModule,
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
