import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { GoogleChartsModule } from 'angular-google-charts';
import { DashboardComponent } from 'src/app/components/dashboard/dashboard.component';
import { UserComponent } from 'src/app/components/user/user.component';
import { LayoutRoutes } from './layout.routing';
import { AppCommonModule } from '../../common/app-common/app-common.module';
import { AddPaymentComponent } from 'src/app/components/payments/add-payment/add-payment.component';
import { ListPaymentsComponent } from 'src/app/components/payments/list-payments/list-payments.component';
import { PaymentDetailsComponent } from 'src/app/components/payments/payment-details/payment-details.component';
import { PaymentStatusComponent } from 'src/app/components/payments/payment-status/payment-status.component';
import { PaymentsComponent } from 'src/app/components/payments/payments.component';
import { ReplaySubject } from 'rxjs';

@NgModule({
  declarations: [
    DashboardComponent,
    UserComponent,
    PaymentsComponent,
    AddPaymentComponent,
    ListPaymentsComponent,
    PaymentDetailsComponent,
    PaymentStatusComponent
  ],
  imports: [
    RouterModule.forChild(LayoutRoutes),
    AppCommonModule,
    GoogleChartsModule.forRoot({ mapsApiKey: 'AIzaSyDIViJw6I2CW86FLXbZGzQpg29MmUH-LXw' })
  ]
})
export class LayoutModule { }
