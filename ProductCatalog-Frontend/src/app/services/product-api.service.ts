import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductApiService {

  constructor(private http:HttpClient) { }

  details() {
    return this.http.get("http://localhost:8087/allProducts")
  }

  getProduct(productCode:string){
    return this.http.get(`http://localhost:8087/getProductDetails?productCode=${productCode}`)
  }

  getProductPrice(productCode:string){
    return this.http.get(`http://localhost:8087/getPrice?productCode=${productCode}`)
  }
  checkService(productCode:string,pincode:string){
    let params = new HttpParams()
    .set('productCode', productCode)
    .set('pincode', pincode);
    return this.http.get(`http://localhost:8087/serviciabilityCheck`, { params })
  }

  getDeliveryDate(productCode:string,pincode:string){
    let params = new HttpParams()
    .set('productCode', productCode)
    .set('pincode', pincode);
    return this.http.get(`http://localhost:8087/getDeliveryDate`, { params })
  }




}
