import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AdminLayoutRoutes } from './admin-layout.routing';

import { DashboardComponent }       from '../../components/dashboard/dashboard.component';
import { UserComponent }            from '../../components/user/user.component';
import { TableComponent }           from '../../components/table/table.component';
import { TypographyComponent }      from '../../components/typography/typography.component';
import { IconsComponent }           from '../../components/icons/icons.component';
import { MapsComponent }            from '../../components/maps/maps.component';
import { NotificationsComponent }   from '../../components/notifications/notifications.component';
import { UpgradeComponent }         from '../../components/upgrade/upgrade.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    NgbModule
  ],
  declarations: [
    DashboardComponent,
    UserComponent,
    TableComponent,
    UpgradeComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
  ]
})

export class AdminLayoutModule {}
