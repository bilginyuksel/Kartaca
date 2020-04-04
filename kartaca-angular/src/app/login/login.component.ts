import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router) { }

  error_message: string = "Login unsuccesfull. Wrong username or password!";
  isLoginFailed: boolean = false;
  username: string;
  password: string;

  ngOnInit(): void {
  }

  login() : void{

    this.authenticationService.getAuthenticationToken(this.username, this.password)
      .subscribe((response) =>{
        const payload = jwt_decode(response.token);
        this.isLoginFailed = false;
        
        localStorage.setItem('username', this.username);
        localStorage.setItem('token', response.token);
        localStorage.setItem('id', payload.user_id.toString());
        localStorage.setItem('email', payload.email);
        localStorage.setItem('exp', payload.exp.toString());
        this.router.navigate(['/post']);
      }, (error) =>{
        // Wrong credentials error.
        console.log(error);
        this.isLoginFailed = true;
      } );

  }

}
