import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IAccount } from './account';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private _url: string = environment.API_URL+'account/id/';
  customerId: any;

  constructor(private http: HttpClient, private login: LoginService) { 
    this.login.currentId.subscribe(customerId => this.customerId = customerId)
  }
  
  //Get account information associated with the current user id
  getAccount(): Observable<IAccount>{
    return this.http.get<IAccount>(this._url+this.customerId);
  }
}
