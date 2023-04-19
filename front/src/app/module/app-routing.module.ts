import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../view/home/home.component';
import { AuthFormComponent } from '../security/auth-form/auth-form.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'userauth', component: AuthFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
