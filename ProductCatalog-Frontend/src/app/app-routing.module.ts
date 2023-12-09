import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home/home-page/home-page.component';
import { LoginPageComponent } from './home/login-page/login-page.component';
import { RegisterationPageComponent } from './home/registeration-page/registeration-page.component';
import { ProductSearchPageComponent } from './products-operations/product-search-page/product-search-page.component';
import { ProductDetailsPageComponent } from './products-operations/product-details-page/product-details-page.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  {
    path: 'login',
    component: LoginPageComponent,
  },
  {
    path: 'register',
    component: RegisterationPageComponent,
  },
  {
    path: 'search',
    component: ProductSearchPageComponent,
    canActivate: [AuthGuard]
  },
  { path: 'product-details/:productCode', component: ProductDetailsPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
