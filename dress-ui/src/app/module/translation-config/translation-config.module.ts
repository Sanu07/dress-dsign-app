import { NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { TranslateLoader, TranslateModule, TranslateService } from '@ngx-translate/core';
import * as _ from 'lodash';




export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, '../../../assets/i18n/', '.json');
}

const translationOptions = {
  loader: {
      provide: TranslateLoader,
      useFactory: HttpLoaderFactory,
      deps: [HttpClient]
  }
};

@NgModule({
  imports: [TranslateModule.forRoot(translationOptions)],
  exports: [TranslateModule],
  providers: [TranslateService]
})
export class TranslationConfigModule {

  private browserLang;

  /**
   * @param translate {TranslateService}
   */
  constructor(private translate: TranslateService) {
      // Setting up Translations
      translate.addLangs(['en', 'it']);
      translate.setDefaultLang('en');
      this.browserLang = translate.getBrowserLang();
      translate.use(this.browserLang.match(/en|it/) ? this.browserLang : 'en');
  }

  public getBrowserLang(){
      if(_.isUndefined(this.browserLang) || _.isNull(this.browserLang)){
          this.browserLang = 'en';
      }
      return this.browserLang;
  }
}
