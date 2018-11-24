import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipoAddComponent } from './component/tipo-add/tipo-add.component';
import { TipoListComponent } from './component/tipo-list/tipo-list.component';
import { RestaurantListComponent } from './component/restaurant-list/restaurant-list.component';
import { RestaurantEditComponent } from './component/restaurant-edit/restaurant-edit.component';
import { RestaurantAddComponent } from './component/restaurant-add/restaurant-add.component';
import { ReservaListComponent } from './component/reserva-list/reserva-list.component';
import { ReservaAddComponent } from './component/reserva-add/reserva-add.component';

const routes: Routes = [
  { path: 'tipo-add', component: TipoAddComponent },
  { path: 'tipo-list', component: TipoListComponent },
  { path: 'restaurant-list', component: RestaurantListComponent },
  { path: 'restaurantes-edit/:id', component: RestaurantEditComponent },
  { path: 'restaurant-add', component: RestaurantAddComponent },
  { path: 'reserva-list', component: ReservaListComponent },
  { path: 'reserva-add', component: ReservaAddComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
