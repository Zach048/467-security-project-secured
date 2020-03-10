import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  _login_url = 'http://localhost:8080/customer/login/';
  _register_url = 'http://localhost:8080/customer/new/';
  httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  private customerId = new BehaviorSubject<String>(localStorage.getItem('customerId'));
  currentId = this.customerId.asObservable();
  
  constructor(private _http: HttpClient) { }

  getCustomerId(id: String) {
    this.customerId.next(id)
  }

  login(userData, userName){
    return this._http.post<any>(this._login_url+userName, userData, this.httpOptions);
  }

  register(userData, userName){
    return this._http.post<any>(this._register_url+userName, userData, this.httpOptions);
  }
}
