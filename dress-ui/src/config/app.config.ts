import { Injectable } from '@angular/core';
import { get } from 'lodash';
import { TranslationConfigModule } from 'src/app/module/translation-config/translation-config.module';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AppConfig {

  private _configurations: any = new Object();
  private _config_path = './assets/json-config/';
  private _resources_path = './assets/resources/';

  constructor( private http: HttpClient) { }

  // Get an Environment Entry by Key
  public getEnvByKey(key: any): any {
    return this._configurations.env[key];
  }

  // Get a Configuration Entryby Key
  public getEntryByKey(key: any): any {
    return this._configurations.config[key];
  }

  // Get a Resource Entry by Key
  public getResourceByKey(key: any): any {
    return get(this._configurations.resource, key);
  }

  // Should be self-explanatory 
  public load(translate: TranslationConfigModule){
    return new Promise((resolve, reject) => {
      // Given env.json
      this.loadFile(this._config_path + 'env.json').then((envData: any) => {
        this._configurations.env = envData;
        // Load production or development configuration file based on before
        this.loadFile(this._config_path + envData.env  + '.json').then((conf: any) => {
          this._configurations.config = conf;
          // Load resources files based on browser language
          this.loadFile(this._resources_path + translate.getBrowserLang() +'.json').then((resource: any) => {
            this._configurations.resource = resource;
            return resolve(true);
          });
        });
      });
    });
  }

  private loadFile(path: string){
    return new Promise((resolve, reject) => {
      this.http.get(path)
      .subscribe((res_data) => {
        return resolve(res_data);
      })
    });
  }

}