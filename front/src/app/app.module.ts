import { NgModule, isDevMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './module/app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './module/material.module';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ToptoolbarComponent } from './layout/toptoolbar/toptoolbar.component';
import { HomeComponent } from './view/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { HeaderInterceptor } from './security/header.interceptor';
import { AuthFormComponent } from './security/auth-form/auth-form.component';

import { JwtModule } from '@auth0/angular-jwt';
import { TopicComponent } from './view/topic/topic.component';
import { TopicformComponent } from './view/topicform/topicform.component';
import { ChatroomboxComponent } from './layout/chatroombox/chatroombox.component';
import { GooglemapComponent } from './layout/googlemap/googlemap.component';
import { StripepaymentComponent } from './view/stripepayment/stripepayment.component';
import { SearchComponent } from './view/search/search.component';
import { FeaturetopicComponent } from './view/featuretopic/featuretopic.component';
export function tokenGetter() {
  return localStorage.getItem('token');
}
@NgModule({
  declarations: [
    AppComponent,
    ToptoolbarComponent,
    HomeComponent,
    AuthFormComponent,
    TopicComponent,
    TopicformComponent,
    ChatroomboxComponent,
    GooglemapComponent,
    StripepaymentComponent,
    SearchComponent,
    FeaturetopicComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    StoreModule.forRoot({}, {}),
    StoreDevtoolsModule.instrument({ maxAge: 25, logOnly: !isDevMode() }),
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        allowedDomains: ['localhost:8080', 'localhost:4200'],
      },
    }),
  ],
  providers: [
    HttpClientModule,
    { provide: HTTP_INTERCEPTORS, useClass: HeaderInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
