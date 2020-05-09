import { Routes } from '@angular/router';

import { DashboardComponent } from '../../components/dashboard/dashboard.component';
import { UserComponent } from '../../components/user/user.component';
import { TableComponent } from '../../components/table/table.component';
import { TypographyComponent } from '../../components/typography/typography.component';
import { IconsComponent } from '../../components/icons/icons.component';
import { MapsComponent } from '../../components/maps/maps.component';
import { NotificationsComponent } from '../../components/notifications/notifications.component';
import { PaymentsComponent } from 'app/components/payments/payments.component';
import { CustomersComponent } from 'app/components/customers/customers.component';
import { MeasurementsComponent } from 'app/components/measurements/measurements.component';
import { OrdersComponent } from 'app/components/orders/orders.component';
import { ListPaymentsComponent } from 'app/components/payments/list-payments/list-payments/list-payments.component';
import { EditPaymentsComponent } from 'app/components/payments/edit-payments/edit-payments/edit-payments.component';

export const AdminLayoutRoutes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'user', component: UserComponent },
  { path: 'table', component: TableComponent },
  { path: 'typography', component: TypographyComponent },
  { path: 'icons', component: IconsComponent },
  { path: 'maps', component: MapsComponent },
  { path: 'notifications', component: NotificationsComponent },
  { path: 'measurements', component: MeasurementsComponent },
  { path: 'customers', component: CustomersComponent },
  { path: 'payments', component: ListPaymentsComponent },
  { path: 'orders', component: OrdersComponent }
];
