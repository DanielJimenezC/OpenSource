import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipoAddComponent } from './component/tipo-add/tipo-add.component';

const routes: Routes = [
  { path: 'tipo-add', component: TipoAddComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
