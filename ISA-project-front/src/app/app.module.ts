import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
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
import { HomePageClientComponent } from './home-page-client/home-page-client.component';
import { SurveyPageComponent } from './survey-page/survey-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ProfileAdminComponent,
    TransfusionCenterProfileComponent,
    AdminCenterDashboardComponent,
    EditProfileComponent,
    PasswordComponentComponent,
    HomePageClientComponent,
    SurveyPageComponent
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

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
