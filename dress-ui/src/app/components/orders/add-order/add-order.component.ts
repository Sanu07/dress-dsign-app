import { Component, OnInit } from '@angular/core';
import { MatChip, MatDialog } from '@angular/material';
import { IMeasurements, IOrder, Order } from 'src/app/models/order';
import { AddOrderModalComponent } from '../modals/add-order-modal/add-order-modal.component';
import * as _ from 'lodash';
import * as moment from 'moment';
import { OrderService } from 'src/app/services/order.service';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from 'src/app/models/customer';

const KURTI = 'Kurti';
const SALWAR = "Salwar";
const SHIRT = "Shirt";
const PANT = "Pant";

const kurtiDefaultMeasurements: IMeasurements[] = [{ name: 'length', size: '20 cm', amount: 100 }]
const salwarDefaultMeasurements: IMeasurements[] = [{ name: 'length', size: '20 cm', amount: 100 }]
const shirtDefaultMeasurements: IMeasurements[] = [{ name: 'length', size: '20 cm', amount: 100 }]
const pantDefaultMeasurements: IMeasurements[] = [{ name: 'length', size: '20 cm', amount: 100 }]

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.scss']
})
export class AddOrderComponent implements OnInit {

  public templates: string[] = [KURTI, SALWAR, SHIRT, PANT];
  public isKurti: boolean = false;
  public isSalwar: boolean = false;
  public isPant: boolean = false;
  public isShirt: boolean = false;
  public measurementsData: IMeasurements[];
  public measurementsDataChunks: IMeasurements[][];
  public customerId: string = "";

  constructor(
    public dialog: MatDialog,
    private orderService: OrderService,
    private customerService: CustomerService
  ) { }

  ngOnInit(): void { }

  onConfirmCustomerId(customerId: string): void {
    console.log(customerId);
  }

  onSaveOrder(): void {
    const order: Order = new Order();
    this.customerService.getCustomer(this.customerId).subscribe((response: Customer) => {
      order.customer = response;
      order.measurements = this.measurementsData;
      order.estimatedDeliveryDate = new Date();
      order.totalAmount = _.sumBy(this.measurementsData, 'amount');
      this.orderService.addOrder(order).subscribe((response: IOrder) => {
        console.log(response);
      });
    });
  }

  toggleSelection(chip: MatChip): void {
    switch (chip.value.replace('check', '').trim()) {
      case KURTI: {
        this.isKurti = !this.isKurti;
        break;
      }
      case SALWAR: {
        this.isSalwar = !this.isSalwar;
        break;
      }
      case SHIRT: {
        this.isShirt = !this.isShirt;
        break;
      }
      case PANT: {
        this.isPant = !this.isPant;
        break;
      }
      default: {
        break;
      }
    }
    chip.toggleSelected();
  }

  onOpenOrder(dressType: string): void {
    this.initializeDefaultItemMeasurements(dressType);
    const dialogRef = this.dialog.open(AddOrderModalComponent, {
      width: '750px',
      restoreFocus: false,
      data: this.measurementsData
    });

    dialogRef.afterClosed().subscribe(result => {
      this.measurementsData = result;
      this.measurementsDataChunks = _.chunk(this.measurementsData, Math.ceil(this.measurementsData.length / 2));
    });
  }

  initializeDefaultItemMeasurements(dressType: string): void {
    switch (dressType) {
      case KURTI: {
        this.measurementsData = this.measurementsData || kurtiDefaultMeasurements;
        break;
      }
      case SALWAR: {
        this.measurementsData = this.measurementsData || salwarDefaultMeasurements;
        break;
      }
      case SHIRT: {
        this.measurementsData = this.measurementsData || shirtDefaultMeasurements;
        break;
      }
      case PANT: {
        this.measurementsData = this.measurementsData || pantDefaultMeasurements;
        break;
      }
      default: {
        break;
      }
    }
  }
}
