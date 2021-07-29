import { Customer } from "./customer";

export interface IMeasurements {
  name: string;
  size: string;
  amount: number;
}

export interface IOrder {
  id: string,
  orderId: string,
  createdAt: string,
  estimatedDeliveryDate: string,
  orderDeliveredOn: string,
  updatedAt: string,
  orderStatus: string,
  status: string,
  version: string,
  customerId: string,
  measurements: Array<IMeasurements>
}

export class Order {
  estimatedDeliveryDate: Date
  totalAmount: number
  customer: Customer
  measurements: Array<IMeasurements>
}
