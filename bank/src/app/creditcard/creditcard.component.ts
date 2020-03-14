import { Component, OnInit, Inject } from '@angular/core';
import { AccountService } from '../account.service';
import { PaymentService } from '../payment.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router'
import { environment } from 'src/environments/environment';
//import { MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-creditcard',
  templateUrl: './creditcard.component.html',
  styleUrls: ['./creditcard.component.css']
})
export class CreditcardComponent implements OnInit {
  public account = {};
  _url = environment.API_URL+'account/payCreditCard/';
  hideButton = false;
  submitted = false;
  acctBal;
  credBal;
  acctNum;
  credNum;
  credPay: number;

  creditForm = new FormGroup({
    creditCardPayment: new FormControl('', [Validators.min(0), Validators.maxLength(25)])
  });

  constructor(private _accountService: AccountService, private _paymentService: PaymentService, private router: Router) { }

  //subscribe to user's accound information so that it can be rendered when page is loaded
  ngOnInit() {
    this._accountService.getAccount()
      .subscribe(data => {
        this.account = data
        for (let key in this.account) {
          if(key == "checkingAccount"){
            this.acctNum = this.account[key].replace(/\d(?=\d{4})/g, "*");
          }
          else if(key == "creditCard"){
            this.credNum = this.account[key].replace(/\d(?=\d{4})/g, "*");
          }
          else if(key == "checkingBalance"){
            this.acctBal = this.account[key];
          }
          else if(key == "creditCardBalance"){
            this.credBal = this.account[key];
          }
        }
      });
  }

  //Ensure that user has entered a valid payment
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
  
  //Validate user credit card payment and submit it to the back end
  //Subscribe to response from back end and log success/error to the console
  onSubmit(){
    //make sure form is only submitted once
    if(this.submitted){
      return false;
    }
    this.credPay = this.creditForm.value.creditCardPayment;
    if(this.validatePayment(this.credPay)){
      //hide button and disable form to prevent duplicate submissions
      this.hideButton = true;
      this.creditForm.disable();
      //submit payment to back-end and capture response
      this._paymentService.register(this._url+this.credPay, this.account)
        .subscribe(
          response => console.log('Successfully submitted credit card payment', response),
          error => console.error('Error processing credit card payment', error)
        )
      this.submitted = true;
    setTimeout (() => {
      alert("Payment Has Been Submitted!");
    }, 200);
    }
  }
  
}
