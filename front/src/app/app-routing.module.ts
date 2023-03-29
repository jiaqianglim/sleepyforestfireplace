import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './global/login/login.component';
import { PagenotfoundComponent } from './layout/pagenotfound/pagenotfound.component';
import { CategoriesComponent } from './view/categories/categories.component';
import { ChatComponent } from './view/chat/chat.component';
import { HomeComponent } from './view/home/home.component';
import { VenueComponent } from './view/venue/venue.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'categories', component: CategoriesComponent },
  { path: 'login', component: LoginComponent },
  { path: 'chat:/channel', component: ChatComponent },
  { path: 'venue:/place', component: VenueComponent },
  { path: '**', component: PagenotfoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
