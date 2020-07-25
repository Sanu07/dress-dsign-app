import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CustomerService } from 'app/services/customer/customer.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { HelperService } from 'app/shared/HelperService/helper.network.sevice';

export class Customer {
  customerRefNo: string;
  customerName: string;
  customerPhone: number;
  customerAddress: string;
  customerEmail?: string;
}

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  public customer: Customer;
  public isAddCustomerEnabled = true;
  public isLoading: boolean;
  public displayButtonText = 'Save';
  public registerCustomerForm: FormGroup;
  public submitted = false;
  public isCustomerAdded = undefined;
  constructor(
    private formBuilder: FormBuilder,
    private services: CustomerService
  ) { }

  ngOnInit(): void {
    this.registerCustomerForm = this.formBuilder.group({
      customerRefNo: ['', Validators.required],
      customerName: ['', Validators.required],
      customerPhone: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      customerAddress: ['', Validators.required],
      customerEmail: ['', Validators.email]
    });
  }

  public onSubmit() {
    this.submitted = true;
    if (this.registerCustomerForm.invalid) {
      return;
    }
    this.isAddCustomerEnabled = false;
    this.displayButtonText = 'Saving';
    this.isLoading = true;
    this.services.addCustomer(this.registerCustomerForm.value).subscribe((response: Customer) => {
      if (response.customerRefNo) {
        this.isCustomerAdded = 'success';
        this.customer = response;
        setTimeout(() => {
          this.isLoading = false;
          this.displayButtonText = 'Saved';
        }, 200);
      }
    },
      (error: HttpErrorResponse) => {
        this.isLoading = false;
        this.isCustomerAdded = 'error';
      });
  }

  get registerFormControl() {
    return this.registerCustomerForm.controls;
  }

  public addCustomer() {
    this.customer = undefined;
    this.isAddCustomerEnabled = true;
    this.displayButtonText = 'Save';
    this.isLoading = false;
    this.submitted = false;
    this.registerCustomerForm.reset();
  }

  updateCustomerCRN() {
    let name = this.registerCustomerForm.get('customerName').value;
    const phone = this.registerCustomerForm.get('customerPhone').value;
    if (name && phone) {
      name = name.trim().charAt(0).toUpperCase().concat(name.trim().charAt(name.length - 1).toUpperCase());
      this.registerCustomerForm.patchValue({
        customerRefNo: name.concat(phone)
      });
    }
  }
}
