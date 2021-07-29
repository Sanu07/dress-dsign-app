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
import { OrdersComponent } from 'src/app/components/orders/orders.component';
import { ListOrdersComponent } from 'src/app/components/orders/list-orders/list-orders.component';
import { AddOrderComponent } from 'src/app/components/orders/add-order/add-order.component';
import { AddOrderModalComponent } from 'src/app/components/orders/modals/add-order-modal/add-order-modal.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FeedbackComponent } from 'src/app/components/feedback/feedback/feedback.component';
import { CustomerComponent } from 'src/app/components/customer/customer.component';
import { AddCustomerComponent } from 'src/app/components/customer/add-customer/add-customer.component';
import { ListCustomerComponent } from 'src/app/components/customer/list-customer/list-customer.component';
import { EditUserComponent } from 'src/app/components/user/modals/edit-user/edit-user.component';

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
    FeedbackComponent,
    CustomerComponent,
    AddCustomerComponent,
    ListCustomerComponent,
    EditUserComponent
  ],
  imports: [
    RouterModule.forChild(LayoutRoutes),
    AppCommonModule,
    ReactiveFormsModule,
    GoogleChartsModule.forRoot({ mapsApiKey: 'AIzaSyDIViJw6I2CW86FLXbZGzQpg29MmUH-LXw' })
  ],
  entryComponents: [
    AddOrderModalComponent,
    EditUserComponent
  ]
})
export class LayoutModule { }
