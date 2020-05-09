import { Component, OnInit } from '@angular/core';

export interface Order {
  crnNo: string,
  orderNo: string,
  name: string,
  phone: string,
  receivedOn: string,
  deliveryStatus: string,
  paymentStatus: Payment
}

export interface Payment {
  paid: string,
  due: string
}

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.css']
})
export class ListOrderComponent implements OnInit {

  public page = 1;
  public pageSize = 5;
  public orders = [
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'LI7643', name: 'John Dow', phone: '8756435423', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'OP8907', name: 'Mick Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'Larry Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741', receivedOn: '10/02/2020',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
  ]

  constructor() { }

  ngOnInit(): void { }

}
