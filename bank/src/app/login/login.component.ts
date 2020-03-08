import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { LoginService } from '../login.service';
import { Router } from '@angular/router'
import { AuthService } from '../services/auth.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  submitted = false;
  login = false;

  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private _loginService: LoginService, private router: Router, private authService: AuthService) { }

  public customerId: number;

  ngOnInit() {
    this.authService.logout();
  }

  onSubmit(){
    this.submitted = true;
    console.log(this.loginForm.value);
    this._loginService.register(this.loginForm.value['password'], this.loginForm.value['username'])
      .subscribe((customerId: any) => {
        if(<number>customerId != -1) {
          this.customerId = customerId;
          localStorage.setItem('customerId', String(this.customerId));
          this._loginService.getCustomerId(String(this.customerId));
          console.log(this.customerId);

          localStorage.setItem('isLoggedIn', 'true');
          localStorage.setItem('token', this.loginForm.value['username']);

          this.router.navigate(['/dashboard']);
        }
        else{
          alert("Invalid username, password, or combination!")
        }
      })
  }

}
