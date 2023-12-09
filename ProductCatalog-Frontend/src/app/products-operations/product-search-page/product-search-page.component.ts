import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductApiService } from 'src/app/services/product-api.service';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserApiService } from 'src/app/services/user-api.service';

@Component({
  selector: 'app-product-search-page',
  templateUrl: './product-search-page.component.html',
  styleUrls: ['./product-search-page.component.sass']
})
export class ProductSearchPageComponent {
message :string =  ""

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

    ngOnInit():void{
      console.log("working");
      this.user.reloadUser()
    }

    viewProductDetails(productCode: string): void {
      this.product.getProduct(productCode).subscribe((response) => {
        console.log(response);
        if(response == null){
          alert("No Details found")
        }
        this.selectedProduct = response;
      });
    }

    viewPriceDetails(productCode: string): void {
      this.product.getProductPrice(productCode).subscribe((response) => {
        console.log(response);
        this.selectedPrice = response;
      });
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
      if(response.length!=0){
        console.log(response)
      this.products = response;
      this.message="";
      }else{
        this.products = []
        this.message="No matching products"
      }
    });
  }

  getUsernameFromLocalStorage(): string {
    const user = localStorage.getItem('user');
    if(user){
    return user;
    }else{
      return " "
    }
  }
  

  sortProductsByPrice(): void {
    this.products.sort((a, b) => a.productPrice - b.productPrice);
  }

  handleLogout(){
    this.user.logout().subscribe((response)=>{
      console.log(response);
      this.router.navigate([``])
    })

    
  }
  

  





}
