import { Router } from '@angular/router';
import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Login } from '../model/login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private authService:AuthService, private router:Router) { }
  public login: Login = new Login();
  ngOnInit(): void {
  }
  SignIn() {
    this.authService.signIn(this.login).subscribe(res => {
      console.log(res);
      console.log(res.accessToken);
      console.log(res.role);
      let role = res.role
      localStorage.setItem('token', res.accessToken);
      localStorage.setItem('role', role);

      if (role == 'CLIENT') this.router.navigate(['/client/home']);
      else if (role == 'MEDICALSTAFF') this.router.navigate(['/medical-staff/admin-center-dashboard']);
      else if (role == 'ADMIN') this.router.navigate(['/admin/']);
      else {
           localStorage.removeItem('token');
           this.router.navigate(['/']);
         }
      });
   
    }

}