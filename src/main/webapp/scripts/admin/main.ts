import { bootstrap }    from '@angular/platform-browser-dynamic';
import { AppComponent } from './app.component';
import { HTTP_PROVIDERS } from '@angular/http';
import {enableProdMode} from '@angular/core';
import { provideForms, disableDeprecatedForms } from '@angular/forms';

enableProdMode();
bootstrap(AppComponent, [HTTP_PROVIDERS, provideForms(), disableDeprecatedForms()]);
