import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { NgbModal, ModalDismissReasons, NgbModalRef, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalContext } from 'app/models/user-auth.model';

@Component({
  selector: 'app-edit-payments',
  templateUrl: './edit-payments.component.html',
  styleUrls: ['./edit-payments.component.css']
})
export class EditPaymentsComponent implements OnInit {
  closeResult = '';
  private modalRef: NgbModalRef;

  @Input() public order;
  // @Output() passEntry: EventEmitter<any> = new EventEmitter();

  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
    console.log(this.order);
  }

  passBack() {
    // this.passEntry.emit(this.user);
    this.activeModal.close(this.order);
  }
}
