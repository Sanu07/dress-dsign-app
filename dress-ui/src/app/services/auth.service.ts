import { Injectable } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public isAuthorized: boolean;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute
    ) { }

  public checkAuthorization() {
    this.isAuthorized = !this.activatedRoute.snapshot.url[0].path.includes('payment-status');
  }
}
