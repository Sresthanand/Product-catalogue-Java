import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductApiService } from 'src/app/services/product-api.service';

@Component({
  selector: 'app-product-details-page',
  templateUrl: './product-details-page.component.html',
  styleUrls: ['./product-details-page.component.sass'],
})
export class ProductDetailsPageComponent implements OnInit {
  productDetails: any;
  pincode: string = '';
  showModal: boolean = false;
  deliveryDate:string='';

  constructor(
    private route: ActivatedRoute,
    private productData: ProductApiService
  ) {}

  ngOnInit(): void {
    let editId = this.route.snapshot.paramMap.get('productCode');
    editId &&
      this.productData.getProduct(editId).subscribe((response) => {
        this.productDetails = response;
        console.log(this.productDetails);
      });
  }

  checkServicibility(productCode: string): void {
    if (this.pincode) {
      console.log('Product Code:', productCode);
      console.log('Pincode:', this.pincode);

      this.productData
        .checkService(productCode, this.pincode)
        .subscribe((response) => {
          console.log(response);
          if (response == true) {
            alert('Deliverable at this pincode');
          } else {
            alert('Not deliverable');
          }
        });
    }
  }

  // checkServicibilityAndDelivery(productCode: string): void {
  //   if (this.pincode) {
  //     console.log('Product Code:', productCode);
  //     console.log('Pincode:', this.pincode);

  //     this.productData.getDeliveryDate(productCode, this.pincode).subscribe(
  //       (response: any) => {
  //         if (response.deliveryDate) {
  //           alert('Delivery date' + response.deliveryDate);
  //         } else {
  //           alert('Not deliverable');
  //         }
  //       },
  //       (error) => {
  //         console.log(error);
  //       }
  //     );
  //   }
  // }

  checkServicibilityAndDelivery(productCode: string): void {
    if (this.pincode) {
      console.log('Product Code:', productCode);
      console.log('Pincode:', this.pincode);
  
      this.productData.getDeliveryDate(productCode, this.pincode).subscribe(
        (response: any) => {
          if (response.deliveryDate) {
            this.deliveryDate = response.deliveryDate;
            this.showModal = true; // Show the modal
          } else {
            alert('Not deliverable');
          }
        },
        (error) => {
          console.log(error);
        }
      );
    }else{
      alert("Please enter pincode first")
    }
  }
  
  hideModal(): void {
    this.showModal = false; // Hide the modal
  }
}
