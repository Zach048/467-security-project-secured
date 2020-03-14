import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;

  loginForm = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.maxLength(25)]),
    password: new FormControl('', [Validators.required,, Validators.maxLength(25)])
  });

  constructor(private _loginService: LoginService, private router: Router, private authService: AuthService) { }

  public customerId: number;

  //When page is initially rendered make sure no user is currently logged in
  ngOnInit() {
    this.authService.logout();
  }

  //Submit username and password to the back-end for authentication
  onSubmit(){
      this.form = this.loginForm;
      this._loginService.login(this.form.value['password'], this.form.value['username'])
      .subscribe((customerId: any) => {
        //Save customer Id if login is authenticated
        if(<number>customerId != -1) {
          this.customerId = customerId;
          localStorage.setItem('customerId', String(this.customerId));
          this._loginService.getCustomerId(String(this.customerId));
          localStorage.setItem('isLoggedIn', 'true');
          localStorage.setItem('token', this.form.value['username']);
          this.router.navigate(['/dashboard']);
        }
        //Alert user that their credentials are invalid and route back to login screen
        else{
          alert("Invalid username, password, or combination!");
          this.router.navigate(['/']);
        }
      });
  }

  //Route to navigate to new user registration form
  register(){
    this.router.navigate(['/registration']);
  }

}