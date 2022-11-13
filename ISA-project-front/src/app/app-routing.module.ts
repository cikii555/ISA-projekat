import { SurveyPageComponent } from './survey-page/survey-page.component';
import { HomePageClientComponent } from './home-page-client/home-page-client.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'login', component:LoginComponent},
  { path: 'registration', component:RegistrationComponent},
  { path: 'home-client', component:HomePageClientComponent},
  { path: 'survey/:id', component:SurveyPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
