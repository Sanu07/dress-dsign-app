import { STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payment-status',
  templateUrl: './payment-status.component.html',
  styleUrls: ['./payment-status.component.scss'],
  providers: [
    {
      provide: STEPPER_GLOBAL_OPTIONS,
      useValue: { displayDefaultIndicatorType: false }
    }
  ]
})
export class PaymentStatusComponent implements OnInit {
  
  public orderPlaced: boolean = true;
  public orderProcessed: boolean = false;
  public isPaymentCompleted: boolean = true;

  constructor() { }

  ngOnInit() {
  }

}
