import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'app/services/auth-service/authentication.service';
import { LoginCredentials, UserRegistration, AuthToken } from 'app/models/user-auth.model';
import { UserRegistrationService } from 'app/services/registration/user-registration.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  isRegisterForm = true;
  invalidLogin = false;
  loginCredentials: LoginCredentials = new LoginCredentials();
  userRegistrationDetails: UserRegistration = new UserRegistration;

  @Input() error: string | null;

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private userRegistrationService: UserRegistrationService
  ) { }

  ngOnInit() { }

  displayRegisterOrLoginForm(event: Event) {
    const elementId: string = (event.target as Element).id;
    this.isRegisterForm = elementId === 'registration' ? true : false;
  }

  authenticateUser() {
    if (true) {
      this.router.navigate(['/dashboard']);
    }
    this.authService.authenticate(this.loginCredentials.username, this.loginCredentials.password).subscribe(
      (data: AuthToken) => {
        console.log(data.token);
        this.router.navigate(['/dashboard']);
        this.invalidLogin = false;
      },
      error => {
        this.invalidLogin = true
        this.error = error.message;

      }
    )
  }

  userRegistration() {
    this.userRegistrationService.userRegistration(this.userRegistrationDetails).subscribe(userData => {
      console.log(userData);
      this.router.navigate(['/dashboard']);
    });
  }
}
