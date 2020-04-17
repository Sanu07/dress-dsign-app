import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserRegistration } from 'app/models/user-auth.model';

const USER_REGISTRATION_URI = 'http://localhost:8080/register';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(
    private http: HttpClient
  ) { }

  userRegistration(userDetails: UserRegistration) {
    return this.http.post<any>(`${USER_REGISTRATION_URI}`, userDetails);
  }
}
