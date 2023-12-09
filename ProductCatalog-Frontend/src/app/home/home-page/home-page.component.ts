import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductApiService } from 'src/app/services/product-api.service';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserApiService } from 'src/app/services/user-api.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.sass']
})
export class HomePageComponent {

  searchCriteria: any = {
    productName: '',
    productBrand: '',
    productCode: ''
  };
  products: any[] = [];
  selectedProduct: any = null;
  selectedPrice:any=null;

  constructor(private user : UserApiService,private http: HttpClient,private product : ProductApiService, private router:Router){
    product.details().subscribe((response)=>{
     this.products = Object.values(response as any);
        console.log(this.products);
    })

    
    }

    viewProductDetails(productCode: string): void {
     alert("Please Login First")
    }

    viewPriceDetails(productCode: string): void {
      alert("Please Login First")
    }
  
    closeModal(): void {
      this.selectedProduct = null;
    }

    closeModal2(): void {
      this.selectedPrice = null;
    }

    checkServicibility(productCode:string): void {
      console.log(productCode)
      this.router.navigate([`/product-details/${productCode}`]);
    }

  searchProducts(): void {
    let params = new HttpParams();
      params = params.set('productName', this.searchCriteria.productName);
      params = params.set('productBrand', this.searchCriteria.productBrand);
      params = params.set('productCode', this.searchCriteria.productCode);
    this.http.get<any[]>('http://localhost:8087/search', { params }).subscribe(response => {
      this.products = response;
    });
  }

  sortProductsByPrice(): void {
    alert("Please login first")
  }

  handleLogout(){
    this.user.logout().subscribe((response)=>{
      console.log(response);
      this.router.navigate([``])
    })
  }

  handleLogin(){
      this.router.navigate([`/login`])
  }
  



}

