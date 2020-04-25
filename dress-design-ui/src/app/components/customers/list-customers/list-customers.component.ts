import { Component, OnInit } from '@angular/core';

export interface Customers {
  crnNo: string,
  name: string,
  phone: string,
  email: string,
  address: string
}

@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit {

  public page = 1;
  public pageSize = 8;
  public customers = [
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' },
    { crnNo: 'KO4132', name: 'John Dow', phone: '6739739283', email: 'dweydf@gmwe.com', address: '3/3 test my address' }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
