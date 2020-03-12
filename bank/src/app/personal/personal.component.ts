import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { RegistrationService } from '../registration.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrls: ['./personal.component.css']
})
export class PersonalComponent implements OnInit {
  public customer = {};
  public showVerification = true;
  public showPersonal = false;
  public customerId;
  public hideButton = false;

  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  personalForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.email, Validators.required]),
    phone: new FormControl('', Validators.required),
    userName: new FormControl('', Validators.required),
    password: new FormControl('')
  });

  constructor(private _loginService: LoginService, private _customerService: CustomerService, private _registrationService: RegistrationService, private router: Router) { }

  ngOnInit() {
    this._customerService.getCustomer()
      .subscribe(data => this.customer = data);
  }
 
  showPassword() {
    let x : any = document.getElementById("pword");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

  showUsername() {
    let x : any = document.getElementById("uname");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

  updateCustomer() {
    for (let key in this.personalForm.value) {
      if(key == "password"){
        if(this.personalForm.value[key] == ""){
          this.customer[key] = null;
        }
        else{
          this.customer[key] = this.personalForm.value[key];
        }
      }
      else{
        this.customer[key] = this.personalForm.value[key];
      }
    }
  }

  verify(){
    this._loginService.login(this.loginForm.value['password'], this.loginForm.value['username'])
      .subscribe((customerId: any) => {
        if(<number>customerId != -1) {
          this.customerId = <string>customerId;
          if(this.customerId == localStorage.getItem('customerId')){
            this.showVerification = false;
            this.showPersonal = true;
          }
          else{
            alert("Credentials Do Not Match Current Account!");
          }
        }
        else{
          alert("Invalid Username, Password, or Combination!");
        }
      });
  }

  onSubmit(){
    this.hideButton = true;
    this.updateCustomer()
    this.personalForm.disable();
    console.log(this.customer);
    this._registrationService.update(this.customer)
      .subscribe(
        response => console.log('Successfully updated customer information', response),
        error => console.error('Error updating customer information', error)
      )
      setTimeout (() => {
        alert("Information Has Been Submitted!");
      }, 200);
  }
}
