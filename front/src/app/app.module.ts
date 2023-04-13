import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HttpClientModule } from '@angular/common/http';
import { ToptoolbarComponent } from './layout/toptoolbar/toptoolbar.component';
import { HomeComponent } from './view/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CategoriesComponent } from './view/categories/categories.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { LoginComponent } from './global/login/login.component';
import { VenueComponent } from './view/venue/venue.component';
import { PagenotfoundComponent } from './layout/pagenotfound/pagenotfound.component';
import { CreateComponent } from './view/create/create.component';

@NgModule({
  declarations: [
    AppComponent,
    ToptoolbarComponent,
    HomeComponent,
    CategoriesComponent,
    SidebarComponent,
    LoginComponent,
    VenueComponent,
    PagenotfoundComponent,
    CreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [HttpClientModule,],
  bootstrap: [AppComponent],
})
export class AppModule {}
