import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SignupComponent } from './components/auth/signup/signup.component';
import { LoginComponent } from './components/auth/login/login.component';
import { LayoutComponent } from './module/layouts/layout/layout.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { AppCommonModule } from './module/common/app-common/app-common.module';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { HttpClientModule } from '@angular/common/http';
import { TranslationConfigModule } from './module/translation-config/translation-config.module';
import { AppConfig } from 'src/config/app.config';

export function initResources(config: AppConfig, translate: TranslationConfigModule) {
  return () => config.load(translate);
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    LayoutComponent,
    WelcomeComponent,
    NavbarComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppCommonModule,
    HttpClientModule,
    TranslationConfigModule
  ],
  providers: [
    AppConfig, {
      provide: APP_INITIALIZER,
      useFactory: initResources,
      deps: [AppConfig, TranslationConfigModule],
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
