import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../view/home/home.component';
import { AuthFormComponent } from '../security/auth-form/auth-form.component';
import { TopicformComponent } from '../view/topicform/topicform.component';
import { TopicComponent } from '../view/topic/topic.component';
import { StripepaymentComponent } from '../view/stripepayment/stripepayment.component';
import { SearchComponent } from '../view/search/search.component';
import { FeaturetopicComponent } from '../view/featuretopic/featuretopic.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: AuthFormComponent },
  { path: 'topicform', component: TopicformComponent },
  { path: 'topic/:topicname', component: TopicComponent },
  { path: 'payment', component: StripepaymentComponent },
  { path: 'search/:term', component: SearchComponent },
  { path: 'featured', component: FeaturetopicComponent },
  { path: '**', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
