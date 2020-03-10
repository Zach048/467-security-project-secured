import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  _update_url = 'http://localhost:8080/customer/update';
  _register_url = 'http://localhost:8080/customer/new';
  httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

  constructor(private _http: HttpClient) { }

  update(userData){
    return this._http.put<any>(this._update_url, userData, this.httpOptions);
  }

  register(userData){
    return this._http.post<any>(this._register_url, userData, this.httpOptions);
  }
}
