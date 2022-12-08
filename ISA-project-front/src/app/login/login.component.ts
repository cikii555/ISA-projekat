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
      var token = res.accessToken;
      var role = res.
      // var token = res.split('')[0];
      // var role = res.split('')[1];
      // localStorage.setItem('token',token);
      // localStorage.setItem('role',role);
      localStorage.setItem("jwt", res.body.accessToken)
      this.router.navigate(['/']);
    })
   
    }

}