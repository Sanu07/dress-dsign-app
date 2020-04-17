import { Routes } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { LoginComponent } from './components/login/login.component';

export const AppRoutes: Routes = [
  {
    path: '',
    redirectTo: 'authenticate',
    pathMatch: 'full',
  },
  { path: 'authenticate', component: LoginComponent },
  { path: 'registration', component: LoginComponent },
  {
    path: '',
    component: AdminLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './layouts/admin-layout/admin-layout.module#AdminLayoutModule'
      }
    ]
  },
]
