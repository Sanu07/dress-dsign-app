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
  public isAddCustomerEnabled = true;
  public isLoading: boolean;
  public displayButtonText = 'Save';
  constructor() { }

  ngOnInit(): void {
  }

  public saveCustomer() {
    this.isAddCustomerEnabled = false;
    this.displayButtonText = 'Saving';
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
      this.displayButtonText = 'Saved';
    }, 2000);
  }

  public addCustomer() {
    this.customer = new Customer();
    this.isAddCustomerEnabled = true;
    this.displayButtonText = 'Save';
    this.isLoading = false;
  }
}
