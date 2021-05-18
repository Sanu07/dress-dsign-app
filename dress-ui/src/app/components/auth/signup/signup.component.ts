import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  signupForm: FormGroup

  constructor() { }

  ngOnInit() {
    this.signupForm = new FormGroup({
      name: new FormControl('', {
        validators: [Validators.required]
      }),
      email: new FormControl('', {
        validators: [Validators.email]
      }),
      phone: new FormControl('', {
        validators: [Validators.required, Validators.pattern('^\d{10}$')]
      }),
      password: new FormControl('', {
        validators: [Validators.required]
      })
    });
  }

}
