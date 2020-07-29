import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit {

  public paymentForm: FormGroup;

  @Output() onPaymentSave: EventEmitter<any> = new EventEmitter<any>();
  @Output() onOrderComplete: EventEmitter<any> = new EventEmitter<any>();
  @Input() customer: any;
  @Input() totalAmount: number;

  constructor(
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.paymentForm = this.formBuilder.group({
      totalAmount: [this.totalAmount, Validators.required],
      paidAmount: ['', Validators.required],
      dueAmount: ['', Validators.required],
    });
  }

  onSavePayment() {
    console.log(this.paymentForm.value);
    this.onPaymentSave.emit(this.paymentForm.value);
    this.onOrderComplete.emit(true);
  }

  updateDueAmount() {
    this.paymentForm.patchValue({
      dueAmount: this.paymentForm.get('totalAmount').value - this.paymentForm.get('paidAmount').value
    });
  }
}
