import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClienteListaComponent} from "./cliente/listar/cliente-lista.component";

const routes: Routes = [
  {
    path: '',
    component: ClienteListaComponent,
    title: 'Clientes',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
