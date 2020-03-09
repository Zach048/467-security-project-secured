import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { CustomValidators } from '../custom-validators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  //At least one of the following: uppercase, lowercase, minimum 6 characters
  passwordPattern = '^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d)[A-Za-z\\d!$%@#£€*?&]{6,}$';
  
  form: FormGroup;

  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  newUserForm = new FormGroup({
    username: new FormControl('', [Validators.minLength(6), Validators.required]),
    password: new FormControl('', [Validators.minLength(8), 
                                   Validators.required,
                                   CustomValidators.patternValidator(/\d/, { hasNumber: true }),
                                   CustomValidators.patternValidator(/[A-Z]/, { hasUpperCase: true }),
                                   CustomValidators.patternValidator(/[a-z]/, { hasLowerCase: true }),
                                   CustomValidators.patternValidator(/[!@#$%^&*]/, { hasSpecialCharacter: true })
                                  ])
  });

  constructor(private _loginService: LoginService, private router: Router, private authService: AuthService) { }

  public customerId: number;

  ngOnInit() {
    this.authService.logout();
  }

  onSubmit(formType: String){
    if(formType === 'loginForm'){
      this.form = this.loginForm;
    }
    else{
      this.form = this.newUserForm;
    }

    console.log(this.form.value);
    //possibly pass number to indicate login or registration
    this._loginService.register(this.form.value['password'], this.form.value['username'])
      .subscribe((customerId: any) => {
        if(<number>customerId != -1) {
          this.customerId = customerId;
          localStorage.setItem('customerId', String(this.customerId));
          this._loginService.getCustomerId(String(this.customerId));
          console.log(this.customerId);

          localStorage.setItem('isLoggedIn', 'true');
          localStorage.setItem('token', this.form.value['username']);
          
          if(formType === 'loginForm'){
            localStorage.setItem('isValidUser', 'true');
            this.router.navigate(['/dashboard']);
          }
          else{
            this.router.navigate(['/personal']);
          }
        }
        else{
          alert("Invalid username, password, or combination!")
        }
      })
  }
}
