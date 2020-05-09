import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EditPaymentsComponent } from '../../edit-payments/edit-payments/edit-payments.component';

@Component({
  selector: 'app-list-payments',
  templateUrl: './list-payments.component.html',
  styleUrls: ['./list-payments.component.css']
})
export class ListPaymentsComponent implements OnInit {
  public page = 1;
  public pageSize = 7;
  public orders = [
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'LI7643', name: 'John Dow', phone: '8756435423',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'OP8907', name: 'Mick Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'Larry Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
    {
      crnNo: 'KO4132', orderRefNo: 'KT1234', name: 'John Dow', phone: '4589658741',
      paymentStatus: { paid: '100', due: '20' }, deliveryStatus: 'pending'
    },
  ]

  public user = {
    name: 'Izzat Nadiri',
    age: 26
  }

  public closeResult: string;
  constructor(public modalService: NgbModal) { }

  ngOnInit() { }

  openModal(order: any) {
    const modalRef = this.modalService.open(EditPaymentsComponent);
    modalRef.componentInstance.order = order;
    modalRef.result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}

