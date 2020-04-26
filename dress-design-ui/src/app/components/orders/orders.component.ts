import { Component, OnInit } from '@angular/core';

export interface OrdersRouteInfo {
  path: string;
  title: string;
  status: boolean;
}

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  public navbarItems: any[];
  public completedAddingCustomer: boolean;
  public trackOrdersRouteInfoArray: number;
  public currentDisplay: string;

  private ROUTES: OrdersRouteInfo[] = [
    { path: 'add-customer', title: 'Customers', status: false },
    { path: 'add-order', title: 'Orders', status: false },
    { path: 'add-dress', title: 'Dress', status: false },
    { path: 'add-payment', title: 'Payments', status: false }
  ];

  constructor() { }

  ngOnInit(): void {
    this.navbarItems = this.ROUTES.filter(navbarItem => navbarItem);
    this.trackOrdersRouteInfoArray = 0;
    this.currentDisplay = this.ROUTES[this.trackOrdersRouteInfoArray].path;
  }

  public selectedNavbar() {

  }

  public addCustomer(event: OrdersRouteInfo) {
    console.log(event);
    this.ROUTES[this.trackOrdersRouteInfoArray].status = true;
    this.currentDisplay = this.ROUTES[this.trackOrdersRouteInfoArray + 1].path;
    this.trackOrdersRouteInfoArray++;
  }
}
