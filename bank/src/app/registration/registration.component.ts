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

  registrationForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.email, Validators.required]),
    phone: new FormControl('', Validators.required),
    userName: new FormControl('', [Validators.required, Validators.minLength(6)]),
    password: new FormControl('', [Validators.required,
                                   Validators.minLength(8), 
                                   CustomValidators.patternValidator(/\d/, { hasNumber: true }),
                                   CustomValidators.patternValidator(/[A-Z]/, { hasUpperCase: true }),
                                   CustomValidators.patternValidator(/[a-z]/, { hasLowerCase: true }),
                                   CustomValidators.patternValidator(/[!@#$%^&*]/, { hasSpecialCharacter: true })
     ])
  });

  constructor(private authService: AuthService, private _registrationService: RegistrationService, private router: Router) { }

  ngOnInit() {
    this.authService.logout();
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
    for (let key in this.registrationForm.value) {
      this.customer[key] = this.registrationForm.value[key];
    }
  }

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
