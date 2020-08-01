import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HelperService } from 'app/shared/HelperService/helper.network.sevice';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(
    private http: HttpClient
  ) { }

  public getAllRegisteredCustomers() {
    return this.http.get(HelperService.URL_INITIAL + 'customers?refresh=true');
  }

  public getDressMeasurementsParams() {
    return this.http.get(HelperService.URL_INITIAL + 'dress/params');
  }

  public saveOrder(body: any) {
    return this.http.post(HelperService.URL_INITIAL + 'orders', body);
  }
}
