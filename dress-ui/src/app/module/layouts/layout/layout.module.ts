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
import { OrdersComponent } from 'src/app/components/orders/orders.component';
import { ListOrdersComponent } from 'src/app/components/orders/list-orders/list-orders.component';
import { AddOrderComponent } from 'src/app/components/orders/add-order/add-order.component';
import { AddOrderModalComponent } from 'src/app/components/orders/modals/add-order-modal/add-order-modal.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FeedbackComponent } from 'src/app/components/utility/feedback/feedback.component';

@NgModule({
  declarations: [
    DashboardComponent,
    UserComponent,
    PaymentsComponent,
    AddPaymentComponent,
    ListPaymentsComponent,
    PaymentDetailsComponent,
    PaymentStatusComponent,
    OrdersComponent,
    ListOrdersComponent,
    AddOrderComponent,
    AddOrderModalComponent,
    FeedbackComponent
  ],
  imports: [
    RouterModule.forChild(LayoutRoutes),
    AppCommonModule,
    ReactiveFormsModule,
    GoogleChartsModule.forRoot({ mapsApiKey: 'AIzaSyDIViJw6I2CW86FLXbZGzQpg29MmUH-LXw' })
  ],
  entryComponents: [
    AddOrderModalComponent
  ]
})
export class LayoutModule { }
