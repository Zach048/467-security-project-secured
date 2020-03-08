import { Component, OnInit, Inject } from '@angular/core';
import { AccountService } from '../account.service';
import { PaymentService } from '../payment.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router'
//import { MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-creditcard',
  templateUrl: './creditcard.component.html',
  styleUrls: ['./creditcard.component.css']
})
export class CreditcardComponent implements OnInit {
  public account = {};
  _url = 'http://localhost:8080/account/payCreditCard/';
  editable = true;
  acctBal;
  credBal;

  creditForm = new FormGroup({
    checkingAccount: new FormControl(''),
    checkingBalance: new FormControl(''),
    creditCard: new FormControl(''),
    creditCardBalance: new FormControl(''),
    creditCardPayment: new FormControl('', Validators.min(0))
  });

  constructor(/*@Inject(MAT_DIALOG_DATA) public data: any,*/ private _accountService: AccountService, private _paymentService: PaymentService, private router: Router) { }

  ngOnInit() {
    this._accountService.getAccount()
      .subscribe(data => {
        this.account = data
        for (let key in this.account) {
          if(key == "checkingAccount" || key == "creditCard"){
            this.account[key] = this.account[key].replace(/\d(?=\d{4})/g, "*");
          }
          else if(key == "accountBalance"){
            this.acctBal = this.account[key];
          }
          else if(key == "creditCardBalance"){
            this.credBal = this.account[key];
          }
        }
      });
  }

  validatePayment(num: number){
    if(num == null){
      alert("Invalid Payment Type!");
      return false;
    }
    else if(num <= 0){
      alert("Payment Must Be Greater than Zero!");
      return false;
    }
    else if(num > this.acctBal){
      alert("Payment Cannot Exceed Checking Account Balance of $" + this.acctBal);
      return false;
    }
    else if(num > this.credBal){
      alert("Payment Cannot Exceed Credit Card Balance of $" + this.credBal);
      return false;
    }
    else if(!Number.isInteger(num)){
      if(num.toString().split(".")[1].length > 2){
        alert("Payment Cannot Exceed Two Decimal Places!");
        return false;
      }
      return true;
    }
    else{
      return true;
    }
  }

  onSubmit(){
    if(this.validatePayment(this.creditForm.value.creditCardPayment)){
      this._paymentService.register(this._url+this.creditForm.value.creditCardPayment, this.account)
        .subscribe(
          response => console.log('Successfully submitted credit card payment', response),
          error => console.error('Error processing credit card payment', error)
        )
      this.router.navigate(['/dashboard']);
    }
  }
  
}
