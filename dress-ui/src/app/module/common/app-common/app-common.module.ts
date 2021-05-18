import { APP_INITIALIZER, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MaterialModule } from '../../material/material.module';
import { TranslationConfigModule } from '../../translation-config/translation-config.module';
import { AppConfig } from 'src/config/app.config';

const COMMON_MODULE = [
  CommonModule,
  MaterialModule,
  FlexLayoutModule,
  ReactiveFormsModule,
  FormsModule
]

@NgModule({
  declarations: [],
  imports: [COMMON_MODULE],
  exports: [COMMON_MODULE]
})
export class AppCommonModule { }
