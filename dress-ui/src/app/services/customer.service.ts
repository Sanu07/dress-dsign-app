import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AddCustomer, Customer } from '../models/customer';
import { HelperService } from './util.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService extends HelperService {

  constructor(private http: HttpClient) {
    super();
  }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.BASE_URL + 'customers');
  }

  getCustomer(customerId: string): Observable<Customer> {
    return this.http.get<Customer>(this.BASE_URL + 'customers/customerId/' + customerId);
  }

  addCustomer(body: AddCustomer): Observable<Customer> {
    return this.http.post<Customer>(this.BASE_URL + 'customers', body);
  }
}
