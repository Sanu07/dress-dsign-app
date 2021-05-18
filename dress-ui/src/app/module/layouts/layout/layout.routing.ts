import { Routes } from "@angular/router";
import { DashboardComponent } from "src/app/components/dashboard/dashboard.component";
import { ListPaymentsComponent } from "src/app/components/payments/list-payments/list-payments.component";
import { PaymentStatusComponent } from "src/app/components/payments/payment-status/payment-status.component";
import { PaymentsComponent } from "src/app/components/payments/payments.component";
import { UserComponent } from "src/app/components/user/user.component";

export const LayoutRoutes: Routes = [
    { path: 'dashboard', component: DashboardComponent },
    { path: 'user', component: UserComponent },
    { path: 'payments', component: PaymentsComponent }
];