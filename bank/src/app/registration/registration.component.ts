import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomValidators } from '../custom-validators';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  public customer = {};

  //New user registration form with validators to control form reactions
  registrationForm = new FormGroup({
    firstName: new FormControl('', [Validators.required, Validators.maxLength(25)]),
    lastName: new FormControl('', [Validators.required, Validators.maxLength(25)]),
    email: new FormControl('', [Validators.email, Validators.required, Validators.maxLength(30)]),
    phone: new FormControl('', [Validators.required, Validators.maxLength(15)]),
    userName: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(25)]),
    password: new FormControl('', [Validators.required,
                                   Validators.minLength(8),
                                   Validators.maxLength(25), 
                                   CustomValidators.patternValidator(/\d/, { hasNumber: true }),
                                   CustomValidators.patternValidator(/[A-Z]/, { hasUpperCase: true }),
                                   CustomValidators.patternValidator(/[a-z]/, { hasLowerCase: true }),
                                   CustomValidators.patternValidator(/[!@#$%^&*]/, { hasSpecialCharacter: true })
     ])
  });

  constructor(private authService: AuthService, private _registrationService: RegistrationService, private router: Router) { }

  //Make sure no user is currently logged in when accessing the form
  ngOnInit() {
    this.authService.logout();
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

  //Loop through form values to populate customer object
  updateCustomer() {
    for (let key in this.registrationForm.value) {
      this.customer[key] = this.registrationForm.value[key];
    }
  }

  //Submit registration form values to the back-end for entry into database
  onSubmit(){
    this.updateCustomer()
    console.log(this.customer);
    this._registrationService.register(this.customer)
      .subscribe(
        response => console.log('Successfully registered customer', response),
        error => console.error('Error registering customer', error)
      )
    this.router.navigate(['/']);
  }

}
