import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdersService } from 'app/services/orders/orders.service';

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

  public active = 1;
  public orders: any = [];
  public customers: any = [];
  public payments: any = [];
  private isOrderSavedSuccessfully: boolean;
  private isMeaserementsSaveSuccessfully: boolean;
  private isPaymentSavedSuccessfully: boolean;
  private orderToBeSaved: any = {};
  private totalAmount = 0;

  constructor(
    private ordersService: OrdersService
  ) { }

  ngOnInit(): void {
    this.ordersService.getAllRegisteredCustomers().subscribe(res => {
      this.customers = res;
    })
  }

  onOrderSave(data: any) {
    console.log(data);
    const isCRNPresent = this.customers.filter((customer) => {
      return (customer.customerRefNo === data.customerRefNo && customer.customerPhone === data.customerPhone)
    });
    if (isCRNPresent.length === 1) {
      this.orderToBeSaved.customer = isCRNPresent[0];
      this.orderToBeSaved.estimatedDeliveryDate = data.deliveryDate;
      this.isOrderSavedSuccessfully = true;
      this.active = 2;
    } else {
      return false;
    }
  }

  onSaveMeasurements(data: any) {
    const dressMeasurements: any = {}
    let totalAmount = 0;
    for (let i = 0; i < data.dressParams.length; i++) {
      for (let j = 0; j < data.dressParams[i].length; j++) {
        dressMeasurements[data.dressParams[i][j].name] = data.dressParams[i][j].measurements.split('|')[0]?.trim();
        const amount = parseFloat(data.dressParams[i][j].measurements.split('|')[1]?.trim());
        if (amount && amount > 0) {
          totalAmount += amount;
        }
      }
    }
    this.totalAmount = totalAmount;
    dressMeasurements.comments = data.comments;
    const dress: any = {};
    dress.dressId = 'D' + this.orderToBeSaved.customer.customerRefNo;
    dress.dressMeasurements = dressMeasurements;
    this.orderToBeSaved.dress = dress;
    this.isMeaserementsSaveSuccessfully = true;
    this.active = 3;
  }

  onPaymentSave(data: any) {
    if (data.paidAmount && data.totalAmount && data.dueAmount) {
      if (this.orderToBeSaved.customer) {
        const payment: any = {};
        payment.paymentId = 'P' + this.orderToBeSaved.customer.customerRefNo;
        payment.paymentType = 'CASH';
        payment.paidAmount = data.paidAmount;
        payment.dueAmount = data.dueAmount;
        payment.totalAmount = this.totalAmount;
        payment.receivedDates = [{
          'paidAmount': data.PaidAmount,
          'payment': payment
        }];
        this.orderToBeSaved.payment = payment;
        this.isPaymentSavedSuccessfully = true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  onOrderComplete(data: any) {
    if (true) {
      console.log(this.orderToBeSaved);
      return false;
    }
    // if (this.isOrderSavedSuccessfully && this.isMeaserementsSaveSuccessfully && this.isPaymentSavedSuccessfully) {
    //   this.ordersService.saveOrder(this.orderToBeSaved).subscribe((res: any) => {
    //     console.log(res);
    //   })
    // }
  }
}
