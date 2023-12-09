import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './home/home.module';
import { BrowserModule } from '@angular/platform-browser';
import { ProductsOperationsModule } from './products-operations/products-operations.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    ProductsOperationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
