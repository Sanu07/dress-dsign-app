import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ToastrModule } from 'ngx-toastr';

import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule } from './shared/navbar/navbar.module';
import { FixedPluginModule } from './shared/fixedplugin/fixedplugin.module';

import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { LoginComponent } from './components/login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BasicAuthHtppInterceptorService } from './services/auth-service/basic-auth-interceptor.service';
import { FormsModule } from '@angular/forms';
import { MeasurementsComponent } from './components/measurements/measurements.component';
import { PaymentsComponent } from './components/payments/payments.component';
import { CustomersComponent } from './components/customers/customers.component';
import { AdminUsersComponent } from './components/admin-users/admin-users.component';
import { OrdersComponent } from './components/orders/orders.component';
import { AddCustomerComponent } from './components/customers/add-customer/add-customer.component';
import { ListCustomersComponent } from './components/customers/list-customers/list-customers.component';
import { NgbModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { SearchFilterPipe } from './shared/filters/search-filter.pipe';
import { ListOrderComponent } from './components/orders/list-order/list-order.component';
import { AddOrderComponent } from './components/orders/add-order/add-order.component';
import { ListPaymentsComponent } from './components/payments/list-payments/list-payments/list-payments.component';
import { EditPaymentsComponent } from './components/payments/edit-payments/edit-payments/edit-payments.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    LoginComponent,
    MeasurementsComponent,
    PaymentsComponent,
    CustomersComponent,
    AdminUsersComponent,
    OrdersComponent,
    AddCustomerComponent,
    ListCustomersComponent,
    SearchFilterPipe,
    ListOrderComponent,
    AddOrderComponent,
    ListPaymentsComponent,
    EditPaymentsComponent
  ],
  imports: [
    BrowserAnimationsModule,
    RouterModule.forRoot(AppRoutes, {
      useHash: true
    }),
    SidebarModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    FixedPluginModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  entryComponents: [
    EditPaymentsComponent
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: BasicAuthHtppInterceptorService, multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
