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
import { ChatComponent } from './view/chat/chat.component';
import { PagenotfoundComponent } from './layout/pagenotfound/pagenotfound.component';
import { CreateComponent } from './view/create/create.component';
import { ChatroomComponent } from './global/chatroom/chatroom.component';
import { RsocketchatComponent } from './global/rsocketchat/rsocketchat.component';
import { RsocketService } from './service/rsocketsocket.service';

@NgModule({
  declarations: [
    AppComponent,
    ToptoolbarComponent,
    HomeComponent,
    CategoriesComponent,
    SidebarComponent,
    LoginComponent,
    VenueComponent,
    ChatComponent,
    PagenotfoundComponent,
    CreateComponent,
    ChatroomComponent,
    RsocketchatComponent,
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
  providers: [HttpClientModule, RsocketService],
  bootstrap: [AppComponent],
})
export class AppModule {}
