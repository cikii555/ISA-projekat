import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TransfusionCenterProfileComponent} from "./transfusion-center-profile/transfusion-center-profile.component";
import {ProfileAdminComponent} from "./profile-admin/profile-admin.component";
import {AdminCenterDashboardComponent} from "./admin-center-dashboard/admin-center-dashboard.component";
import {PasswordComponentComponent} from "./password-component/password-component.component";
import {EditProfileComponent} from "./edit-profile/edit-profile.component";

const routes: Routes = [
  { path: 'login', component:LoginComponent},
  { path: 'registration', component:RegistrationComponent},
  {path:'centerprofile', component:TransfusionCenterProfileComponent},
  {path:'admincenter',component:ProfileAdminComponent,children: [
      {path: 'password',component: PasswordComponentComponent },
      {path: 'edit',component: EditProfileComponent}
    ]},
  {path:'admin-center-dashboard',component:AdminCenterDashboardComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
