import { SystemAdminComponent } from './system-admin/system-admin.component';
import { SurveyPageComponent } from './survey-page/survey-page.component';
import { HomePageClientComponent } from './home-page-client/home-page-client.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TransfusionCenterProfileComponent} from "./transfusion-center-profile/transfusion-center-profile.component";
import {ProfileAdminComponent} from "./profile-admin/profile-admin.component";
import {AdminCenterDashboardComponent} from "./admin-center-dashboard/admin-center-dashboard.component";
import {PasswordComponentComponent} from "./password-component/password-component.component";
import {EditProfileComponent} from "./edit-profile/edit-profile.component";
import {ViewOtherAdminsComponent} from "./view-other-admins/view-other-admins.component";
import { EditClientComponent } from './edit-client/edit-client.component';
import {TransfusionCenterPanelComponent} from "./transfusion-center-panel/transfusion-center-panel.component";
import { ClientComponent } from './client/client.component';
import { AdminComponent } from './admin/admin.component';
import { AuthorizationGuard } from './login/authorization.guard';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'client', component: ClientComponent,
    data: {
    allowedRoles: ['CLIENT']
    }, 
    canActivate: [AuthorizationGuard] },
  { path: 'admin', component: SystemAdminComponent, 
    data: {
    allowedRoles: ['ADMIN']
    }, 
    canActivate: [AuthorizationGuard] },

  { path: 'medical-staff', component: AdminComponent, 
    data: {
    allowedRoles: ['MEDICALSTAFF']
    }, 
    canActivate: [AuthorizationGuard] },
  { path: 'registration', component:RegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
