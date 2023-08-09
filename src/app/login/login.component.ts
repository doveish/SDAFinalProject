import { Component, OnInit } from '@angular/core';
import{ AuthService } from '../service/AuthService'
import { Router } from '@angular/router';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(private authService: AuthService,
    private router: Router,) {}

  ngOnInit(): void {
   
  }

  handleLogin() {
    console.log(this.password, this.username);
    this.authService.login(this.username, this.password).subscribe((result) => {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful';
      this.router.navigate(['home']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }
}
