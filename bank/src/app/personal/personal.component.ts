import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { RegistrationService } from '../registration.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrls: ['./personal.component.css']
})
export class PersonalComponent implements OnInit {
  public customer = {};

  personalForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.email, Validators.required]),
    phone: new FormControl('', Validators.required),
    userName: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    newPassword: new FormControl('')
  });

  constructor(private _customerService: CustomerService, private _registrationService: RegistrationService, private router: Router) { }

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

  showNewPassword() {
    let x : any = document.getElementById("newpword");
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
      this.customer[key] = this.personalForm.value[key];
    }
  }

  onSubmit(){
    this.updateCustomer()
    localStorage.setItem('isValidUser', 'true');
    console.log(this.customer);
    this._registrationService.update(this.customer)
      .subscribe(
        response => console.log('Successfully updated customer information', response),
        error => console.error('Error updating customer information', error)
      )
    this.router.navigate(['/dashboard']);
  }
}
