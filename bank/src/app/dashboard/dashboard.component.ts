import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public customer = {};
  public account = {};
  public show = false;

  constructor(private _customerService: CustomerService, private _accountService: AccountService) { }

  //subscribe to user's personal and account information to populate the page
  ngOnInit() {
    /*
    setTimeout (() => {
      this._customerService.getCustomer()
        .subscribe(data => this.customer = data);
      this.show = true;
    }, 500);
    */
   this.show = true;
    this._customerService.getCustomer()
        .subscribe(data => this.customer = data);
    this._accountService.getAccount()
      .subscribe(data => {
        this.account = data
        //hide the user's checking account and credit card numbers using asterisks
        for (let key in this.account) {
          if(key == "checkingAccount" || key == "creditCard"){
            this.account[key] = this.account[key].replace(/\d(?=\d{4})/g, "*");
          }
        }
      });
  }
}
