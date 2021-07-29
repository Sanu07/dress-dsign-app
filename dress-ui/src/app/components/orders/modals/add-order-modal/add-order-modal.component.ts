import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { IMeasurements } from 'src/app/models/order';

@Component({
  selector: 'app-add-order-modal',
  templateUrl: './add-order-modal.component.html',
  styleUrls: ['./add-order-modal.component.scss']
})
export class AddOrderModalComponent implements OnInit {
  
  constructor(
    public dialogRef: MatDialogRef<AddOrderModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: IMeasurements[],
    private fb: FormBuilder
  ) { }

  @ViewChild('customTemplate', { static: false })
  public customTemplate: HTMLElement;

  productForm: FormGroup;

  ngOnInit(): void {
    this.productForm = this.fb.group({
      order: this.fb.array([])
    });
    this.populateTemplateOrderFields();
  }

  addOrderField() {
    this.order.push(this.fb.group({ name: '', size: '', amount: '' }));
    console.log(this.order);
  }

  populateTemplateOrderFields() {
    this.data.forEach((value) => {
      this.order.push(this.fb.group(value));
    })
  }

  deleteOrderField(index) {
    this.order.removeAt(index);
  }

  get order() {
    return this.productForm.get('order') as FormArray;
  }
}
