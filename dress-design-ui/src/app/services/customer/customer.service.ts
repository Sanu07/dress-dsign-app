import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HelperService } from 'app/shared/HelperService/helper.network.sevice';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Customer } from 'app/components/customers/add-customer/add-customer.component';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  addCustomer(body: Customer): Observable<Customer> {
    return this.http.post<any>(HelperService.URL_INITIAL + 'customers', body);
  }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(HelperService.URL_INITIAL + 'customers?refresh=true');
  }
}
