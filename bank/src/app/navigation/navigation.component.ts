import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  id: string;

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
    this.id = localStorage.getItem('token');
  }

  //Remove session token to prevent user from accessing site after logging out
  logout() {
    this.authService.logout();
  }
}
