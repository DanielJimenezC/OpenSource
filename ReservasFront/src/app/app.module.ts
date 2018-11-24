import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule  } from '@angular/common/http'; 
import { FormsModule } from '@angular/forms';

import { TipoAddComponent } from './component/tipo-add/tipo-add.component';
import { TipoListComponent } from './component/tipo-list/tipo-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TipoAddComponent,
    TipoListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
