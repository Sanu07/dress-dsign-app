import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { AddCustomer, Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.scss']
})
export class AddCustomerComponent implements OnInit {

  addCustomerForm: FormGroup;
  isLoading = false;
  isSubmitted = false;
  isCustomerAdded = false;
  errorMessage: string;

  constructor(
    private snackBar: MatSnackBar,
    private formBuilder: FormBuilder,
    private customerService: CustomerService) { }

  ngOnInit() {
    this.initializeInstanceData();
    this.initializeForm();
  }

  initializeForm(): void {
    this.addCustomerForm = this.formBuilder.group({
      customerName: ['', Validators.required],
      phone: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      address: ['', Validators.required],
      email: ['', Validators.email]
    });
  }

  initializeInstanceData() {
    this.errorMessage = '';
    this.isLoading = false;
    this.isSubmitted = false;
    this.isCustomerAdded = false;
  }

  onAddCustomer() {
    this.isSubmitted = true;
    if (this.addCustomerForm.invalid) {
      return;
    }
    this.isLoading = true;
    const customerData: AddCustomer = this.addCustomerForm.value;
    this.customerService.addCustomer(customerData).subscribe((response: Customer) => {
      if (response.id) {
        this.isCustomerAdded = true;
        setTimeout(() => {
          this.isLoading = false;
          this.snackBar.open('Customer with name ' + response.customerName + ' saved successfully', 'close', {
            duration: 4000,
          });
        }, 1000);
      }
    },
      (error: HttpErrorResponse) => {
        this.isLoading = false;
        this.isCustomerAdded = false;
        this.errorMessage = error.message;
      });
  }
}
