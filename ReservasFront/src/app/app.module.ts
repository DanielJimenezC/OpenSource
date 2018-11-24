import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule  } from '@angular/common/http'; 
import { FormsModule } from '@angular/forms';

import { TipoAddComponent } from './component/tipo-add/tipo-add.component';
import { TipoListComponent } from './component/tipo-list/tipo-list.component';
import { RestaurantListComponent } from './component/restaurant-list/restaurant-list.component';
import { RestaurantEditComponent } from './component/restaurant-edit/restaurant-edit.component';
import { RestaurantAddComponent } from './component/restaurant-add/restaurant-add.component';
import { ReservaListComponent } from './component/reserva-list/reserva-list.component';
import { ReservaAddComponent } from './component/reserva-add/reserva-add.component';

@NgModule({
  declarations: [
    AppComponent,
    TipoAddComponent,
    TipoListComponent,
    RestaurantListComponent,
    RestaurantEditComponent,
    RestaurantAddComponent,
    ReservaListComponent,
    ReservaAddComponent
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
