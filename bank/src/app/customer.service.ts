import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ICustomer } from './customer';
import { Observable} from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  //private _url: string = "/assets/data/customer.json"
  private _url: string = "http://localhost:8080/customer/id/"
  customerId: any;
  
  constructor(private http: HttpClient, private login: LoginService) { 
    this.login.currentId.subscribe(customerId => this.customerId = customerId)
  }
  
  //Get account information associated with the current user id
  getCustomer(): Observable<ICustomer>{
    console.log(this.customerId);
    return this.http.get<ICustomer>(this._url+this.customerId);
  }
}
