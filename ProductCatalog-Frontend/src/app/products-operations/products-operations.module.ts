import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductSearchPageComponent } from './product-search-page/product-search-page.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ProductDetailsPageComponent } from './product-details-page/product-details-page.component';


@NgModule({
  declarations: [
    ProductSearchPageComponent,
    ProductDetailsPageComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ]
})
export class ProductsOperationsModule { }
