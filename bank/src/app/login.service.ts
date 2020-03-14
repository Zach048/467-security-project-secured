import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  _login_url = environment.API_URL+'customer/login/';
  _register_url = environment.API_URL+'customer/new/';
  httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  private customerId = new BehaviorSubject<String>(localStorage.getItem('customerId'));
  currentId = this.customerId.asObservable();
  
  constructor(private _http: HttpClient) { }

  //Get current user's id
  getCustomerId(id: String) {
    this.customerId.next(id)
  }

  //Send username and password to back-end for authentication
  login(userData, userName){
    return this._http.post<any>(this._login_url+userName, userData, this.httpOptions);
  }

  //Register the username and password in the database
  register(userData, userName){
    return this._http.post<any>(this._register_url+userName, userData, this.httpOptions);
  }
}
