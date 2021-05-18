import { Routes } from "@angular/router";
import { DashboardComponent } from "src/app/components/dashboard/dashboard.component";
import { OrdersComponent } from "src/app/components/orders/orders.component";
import { PaymentsComponent } from "src/app/components/payments/payments.component";
import { UserComponent } from "src/app/components/user/user.component";

export const LayoutRoutes: Routes = [
    { path: 'dashboard', component: DashboardComponent },
    { path: 'user', component: UserComponent },
    { path: 'payments', component: PaymentsComponent },
    { path: 'orders', component: OrdersComponent }
];