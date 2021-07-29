import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { IOrder, Order } from 'src/app/models/order';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-list-orders',
  templateUrl: './list-orders.component.html',
  styleUrls: ['./list-orders.component.scss']
})
export class ListOrdersComponent implements OnInit {

  dataSource = new MatTableDataSource();;
  displayedColumns: string[] = ['orderId', 'customerId', 'orderStatus', 'createdAt', 'estimatedDeliveryDate', 'orderDeliveredOn'];

  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: false }) sort: MatSort;

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.orderService.getAllOrders().subscribe((response: Array<IOrder>) => {
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
      id: 'orderId',
      value: filterValue
    });
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
