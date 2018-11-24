import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipoAddComponent } from './component/tipo-add/tipo-add.component';
import { TipoListComponent } from './component/tipo-list/tipo-list.component';

const routes: Routes = [
  { path: 'tipo-add', component: TipoAddComponent },
  { path: 'tipo-list', component: TipoListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
