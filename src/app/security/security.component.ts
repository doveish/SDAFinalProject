import { Component, OnInit } from '@angular/core';
import { JwtClientService } from '../service/jwt-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {
  authRequest: any = {};
  username: string;
  password: string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  response: string | null = null;

  constructor(private service: JwtClientService,
    private router: Router) {}

  ngOnInit(): void {}

  login() {
    this.service.generateToken(this.authRequest).subscribe(
      (data: any) => {
        console.log(data)
        sessionStorage.setItem('token',data)
        this.accessApi(data);
        this.invalidLogin = false;
        this.loginSuccess = true;
        
        this.successMessage = 'Login Successful';
        this.router.navigate(['/home']);
      },
      (error: any) => {
        console.error('Error logging in:', error);
        this.invalidLogin = true;
      this.loginSuccess = false;
      
      
      }
    );
  }

  accessApi(token: string) {
    this.service.welcome(token).subscribe(
      (data: any) => {
        this.response = data;
      },
      (error: any) => {
        console.error('Error accessing API:', error);
      }
    );
  }


}
