import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterationPageComponent } from './registeration-page/registeration-page.component';
import { AppRoutingModule } from '../app-routing.module';
import {FormsModule} from '@angular/forms'
import {HttpClientModule} from '@angular/common/http'



@NgModule({
  declarations: [
    HomePageComponent,
    LoginPageComponent,
    RegisterationPageComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class HomeModule { }
