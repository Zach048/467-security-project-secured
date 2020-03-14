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
    username: new FormControl('', [Validators.required, Validators.maxLength(25)]),
    password: new FormControl('', [Validators.required, Validators.maxLength(25)])
  });

  personalForm = new FormGroup({
    firstName: new FormControl('', [Validators.required, Validators.maxLength(25)]),
    lastName: new FormControl('', [Validators.required, Validators.maxLength(25)]),
    email: new FormControl('', [Validators.email, Validators.required, Validators.maxLength(30)]),
    phone: new FormControl('', [Validators.required, Validators.maxLength(15)]),
    userName: new FormControl('', [Validators.required, Validators.maxLength(25)]),
    password: new FormControl('', Validators.maxLength(25))
  });

  constructor(private _loginService: LoginService, private _customerService: CustomerService, private _registrationService: RegistrationService, private router: Router) { }

  //Subscribe to user's personal information to prepopulate the form
  ngOnInit() {
    this._customerService.getCustomer()
      .subscribe(data => this.customer = data);
  }
 
  //Toggles between plaintext and password for the password field on the form
  //Controlled by checkbox underneath the password field on the form
  showPassword() {
    let x : any = document.getElementById("pword");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

  //Toggles between plaintext and password for the username field on the form
  //Controlled by checkbox underneath the username field on the form
  showUsername() {
    let x : any = document.getElementById("uname");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

  //Loop through form fields to populate customer object
  updateCustomer() {
    for (let key in this.personalForm.value) {
      //Password update is not required, convert to null if not updating
      if(key == "password"){
        if(this.personalForm.value[key] == ""){
          this.customer[key] = null;
        }
        //Otherwise update password with the value from the form
        else{
          this.customer[key] = this.personalForm.value[key];
        }
      }
      else{
        this.customer[key] = this.personalForm.value[key];
      }
    }
  }

  //Verify user's username and password before granting access to the personal form
  verify(){
    this._loginService.login(this.loginForm.value['password'], this.loginForm.value['username'])
      .subscribe((customerId: any) => {
        if(<number>customerId != -1) {
          this.customerId = <string>customerId;
          //Verify that user's id matches the id associated with the current session
          if(this.customerId == localStorage.getItem('customerId')){
            this.showVerification = false;
            this.showPersonal = true;
          }
          else{
            //Credentials match another user, not the current user
            alert("Credentials Do Not Match Current Account!");
          }
        }
        else{
          //Credentials are invalid
          alert("Invalid Username, Password, or Combination!");
        }
      });
  }

  //Submit the personal form to the back-end for entry into database
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
