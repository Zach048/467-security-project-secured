import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.isLoggedIn() && this.isValidUser()) {
      return true;
    }
    else if (this.isLoggedIn() && !this.isValidUser()) {
      this.router.navigate(['/personal']);
    }
    else {
      this.router.navigate(['/']);
      return false;
    }
  }

  public isLoggedIn(): boolean {
    let status = false;
    if (localStorage.getItem('isLoggedIn') == "true") {
      status = true;
    } else {
      status = false;
    }
    return status;
  }

  public isValidUser(): boolean {
    let status = false;
    if (localStorage.getItem('isValidUser') == "true") {
      status = true;
    } else {
      status = false;
    }
    return status;
  }
}
