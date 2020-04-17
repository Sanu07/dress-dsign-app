import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { LoginCredentials } from 'app/models/user-auth.model';

export class User {
  constructor(public status: string) { }
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient) { }
  // Provide username and password for authentication, and once authentication is successful,
  // store JWT token in session
  authenticate(username: string, password: string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient
      .post<any>('http://localhost:8080/authenticate', { username: username, password: password })
      .pipe(
        map(userData => {
          sessionStorage.setItem('username', username);
          const tokenStr = 'Bearer ' + userData.token;
          sessionStorage.setItem('token', tokenStr);
          return userData;
        })
      );
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username');
  }
}
