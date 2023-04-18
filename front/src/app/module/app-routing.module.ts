import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../view/home/home.component';
import { LoginComponent } from '../security/login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'userauth', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
