import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { AccountService } from '../account.service';
//import { MatDialog } from '@angular/material';
//import { CreditcardComponent } from '../creditcard/creditcard.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public customer = {};
  public account = {};

  constructor(private _customerService: CustomerService, private _accountService: AccountService/*, public dialog: MatDialog*/) { }

  ngOnInit() {
    this._customerService.getCustomer()
      .subscribe(data => this.customer = data);
    this._accountService.getAccount()
      .subscribe(data => {
        this.account = data
        for (let key in this.account) {
          if(key == "checkingAccount" || key == "creditCard"){
            this.account[key] = this.account[key].replace(/\d(?=\d{4})/g, "*");
          }
        }
      });
  }
/*
  creditModal(){
    let dialogRef = this.dialog.open(CreditcardComponent, {data: this.account});

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog Result: ${result}`);
    });
  }
*/
}
