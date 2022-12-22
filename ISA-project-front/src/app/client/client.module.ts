import { CenterAppointmentsComponent } from './../center-appointments/center-appointments.component';
import { AuthorizationGuard } from './../login/authorization.guard';
import { ClientComponent } from './client.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HomePageClientComponent } from '../home-page-client/home-page-client.component';
import { EditClientComponent } from '../edit-client/edit-client.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from '../material/material.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatDividerModule } from '@angular/material/divider';
import { SurveyPageComponent } from '../survey-page/survey-page.component';
import { FutureAppointmentsComponent } from '../future-appointments/future-appointments.component';


const routes: Routes = [
  {
    path: 'client',
    component: ClientComponent,
    data: {
      allowedRoles: ['CLIENT']
    },
    canActivate:[AuthorizationGuard],
    children: [
        { path: 'home', component:HomePageClientComponent},
        { path: 'edit',component:EditClientComponent},
        { path: 'survey', component:SurveyPageComponent},
        { path: 'future-appointments', component:FutureAppointmentsComponent},
        { path: 'appointments/:id', component: CenterAppointmentsComponent},
    ]
  }
]
@NgModule({

    declarations: [
        ClientComponent,
        HomePageClientComponent,
        EditClientComponent,
        SurveyPageComponent,
        FutureAppointmentsComponent,
      CenterAppointmentsComponent
    ],
    exports: [
        HomePageClientComponent
    ],
    imports: [
        CommonModule,
        RouterModule.forChild(routes),
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MaterialModule,
        FormsModule,
        HttpClientModule,
        MatCardModule,
        MatSidenavModule,
        MatDividerModule,
    ]




})
export class ClientModule { }
