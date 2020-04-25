import { Component, OnInit } from '@angular/core';

export class Customer {
  customerRefNo: string;
  customerName: string;
  customerPhone: number;
  customerAddress: string;
  customerEmail?: string;
}

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  public customer = new Customer();
  constructor() { }

  ngOnInit(): void {
  }

  public saveCustomer() {
    console.log(this.customer);
  }
}
