import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { UsuarioPerfilFireService } from './shared/models/usuario-perfil-fire.service';


const routes: Routes = 
[
  { path: 'menu', component: MenuComponent},
  { path: '**', redirectTo: '/', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  schemas: [NO_ERRORS_SCHEMA]

})
export class AppRoutingModule { }
export const routingComponents = [ MenuComponent ];