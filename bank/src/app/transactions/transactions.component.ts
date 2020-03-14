import { Component, OnInit } from '@angular/core';
import { TransactionsService } from '../transactions.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  public transactions = []

  constructor(private _transactionsService: TransactionsService) { }

  //Subscribe to the transactions service to populate the list of user's transactions
  ngOnInit() {
    this._transactionsService.getTransactions()
      .subscribe(data => this.transactions = data);
  }

}
