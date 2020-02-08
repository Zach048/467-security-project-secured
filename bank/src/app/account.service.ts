import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IAccount } from './account';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private _url: string = "http://localhost:8080/account/id/"
  customerId: any;

  constructor(private http: HttpClient, private login: LoginService) { 
    this.login.currentId.subscribe(customerId => this.customerId = customerId)
  }
  
  getAccount(): Observable<IAccount>{
    return this.http.get<IAccount>(this._url+this.customerId);
  }
}
