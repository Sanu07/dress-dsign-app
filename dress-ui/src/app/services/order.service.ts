import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IOrder, Order } from '../models/order';
import { HelperService } from './util.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService extends HelperService {

  constructor(private http: HttpClient) {
    super();
  }

  getAllOrders(): Observable<IOrder[]> {
    return this.http.get<IOrder[]>(this.BASE_URL + 'orders');
  }

  addOrder(body: Order): Observable<IOrder> {
    return this.http.post<IOrder>(this.BASE_URL + 'orders', body);
  }
}
