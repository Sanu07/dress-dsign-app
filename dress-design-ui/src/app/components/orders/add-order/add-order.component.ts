import { Component, OnInit, Output, EventEmitter, Input, OnChanges, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit, OnChanges {

  public orderForm: FormGroup;
  public loading = false;

  @Output() onOrderSave: EventEmitter<any> = new EventEmitter<any>();
  @Input() isValidCRN: number;

  constructor(
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.orderForm = this.formBuilder.group({
      customerRefNo: ['', Validators.required],
      customerPhone: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      deliveryDate: ['', Validators.required]
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    // only run when property "data" changed
    if (changes['isValidCRN']) {
      console.log('changed :: ' + this.isValidCRN);
    }
  }

  onOrderSubmit() {
    this.loading = true;
    if (this.orderForm.invalid) {
      return;
    }
    this.onOrderSave.emit(this.orderForm.value);
    console.log('CRN :: ' + this.isValidCRN);
  }

}
