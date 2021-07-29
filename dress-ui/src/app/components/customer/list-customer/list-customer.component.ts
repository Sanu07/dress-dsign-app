import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.scss']
})
export class ListCustomerComponent implements OnInit {

  dataSource = new MatTableDataSource();;
  displayedColumns: string[] = ['customerId', 'customerName', 'phone', 'email', 'address'];

  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: false }) sort: MatSort;

  constructor(private customerService: CustomerService) { }

  ngOnInit() { 
    this.customerService.getAllCustomers().subscribe((response: Array<Customer>) => {
      this.dataSource.data = response;
      this.updateView();
    });
  }

  updateView(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(filterValue: string) {
    const tableFilters = [];
    tableFilters.push({
      id: 'customerName',
      value: filterValue
    });
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
