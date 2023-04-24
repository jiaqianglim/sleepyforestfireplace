import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../view/home/home.component';
import { AuthFormComponent } from '../security/auth-form/auth-form.component';
import { TopicformComponent } from '../view/topicform/topicform.component';
import { TopicComponent } from '../view/topic/topic.component';
import { StripepaymentComponent } from '../view/stripepayment/stripepayment.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: AuthFormComponent },
  { path: 'topicform', component: TopicformComponent },
  { path: 'topic/:topicname', component: TopicComponent },
  { path: 'payment', component: StripepaymentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
