import { Component, OnInit, Output, EventEmitter, Input, OnChanges, SimpleChanges, ChangeDetectorRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit, OnChanges {

  public paymentForm: FormGroup;

  @Output() onPaymentSave: EventEmitter<any> = new EventEmitter<any>();
  @Output() onOrderComplete: EventEmitter<any> = new EventEmitter<any>();
  @Input() customer: any;
  @Input() totalAmount: number;

  constructor(
    private formBuilder: FormBuilder,
    private ref: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.paymentForm = this.formBuilder.group({
      totalAmount: [this.totalAmount, Validators.required],
      paidAmount: ['', Validators.required],
      dueAmount: ['', Validators.required],
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes.totalAmount && this.paymentForm) {
      this.paymentForm.patchValue({
        totalAmount: changes.totalAmount.currentValue,
      });
    }
  }

  onSavePayment() {
    console.log(this.paymentForm.value);
    this.onPaymentSave.emit(this.paymentForm.value);
    this.onOrderComplete.emit(true);
  }

  updateDueAmount() {
    const dueAmount = this.paymentForm.get('totalAmount').value - this.paymentForm.get('paidAmount').value;
    this.paymentForm.patchValue({
      dueAmount: dueAmount > 0 ? dueAmount : 0
    });
  }
}
