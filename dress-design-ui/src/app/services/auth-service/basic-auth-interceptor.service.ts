import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHtppInterceptorService implements HttpInterceptor {

  private excludeURLS = [
    '/',
    '/authenticate'
  ];

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {

    if (this.excludeURLS.indexOf(req.url) >= 0) {
      if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
        req = req.clone({
          setHeaders: {
            Authorization: sessionStorage.getItem('token')
          }
        })
      }
      return next.handle(req);
    } else {
      return next.handle(req);
    }
  }
}
