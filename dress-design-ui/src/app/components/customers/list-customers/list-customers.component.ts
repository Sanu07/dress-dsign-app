import { Component, OnInit } from '@angular/core';
import { Customer } from '../add-customer/add-customer.component';
import { CustomerService } from 'app/services/customer/customer.service';

@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit {

  public page = 1;
  public pageSize = 8;
  public customers: Array<Customer>

  constructor(private customerservice: CustomerService) { }

  ngOnInit(): void {
    this.customerservice.getAllCustomers().subscribe((response: Array<Customer>) => {
      this.customers = response;
    })
  }

}
