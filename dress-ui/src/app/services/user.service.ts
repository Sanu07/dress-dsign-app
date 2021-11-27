import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from '../models/user';
import { HelperService } from './util.service';

@Injectable({
  providedIn: 'root'
})
export class UserService extends HelperService {

  constructor(private http: HttpClient) {
    super();
  }

  getAllUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.BASE_URL + 'users');
  }

  updateUserDetails(user: IUser): Observable<IUser> {
    return this.http.put<IUser>(this.BASE_URL + 'users', user);
  }

  addUser(user: IUser, profileImage: File): Observable<IUser> {
    const formData = new FormData();
    formData.append("file", profileImage);
    formData.append('userData', new Blob([JSON.stringify(user)], {
      type: "application/json"
    }));
    return this.http.post<IUser>(this.BASE_URL + 'users', formData);
  }
}
