import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserApiService } from 'src/app/services/user-api.service';

@Component({
  selector: 'app-registeration-page',
  templateUrl: './registeration-page.component.html',
  styleUrls: ['./registeration-page.component.sass']
})
export class RegisterationPageComponent {
  user: any = {
    username : "",
    pass : ""
  };


  constructor(private router: Router, private userService: UserApiService) { }

// submit() {
//   if (!this.user || this.user.username.trim() === "" || this.user.pass.trim() === ""){
//     alert("Please Enter the credentials")
//   }
// //   }else if(this.userService.checkLogin(this.user.username, this.user.pass)){
// //     alert("Already Registered please login")

// // }
//   else{
//   this.userService.register(this.user).subscribe((result) => {
//     console.log(result)
//     if (result) {
      
//     } else {
//       console.log("Wrong Credentials");
//     }
//   });
// }


submit() {
  if (!this.user || this.user.username.trim().length < 4) {
    alert("Username should be at least 4 characters long");
  } else if (!this.user || this.user.pass.trim().length < 6 || this.user.pass.trim().length > 12) {
    alert("Password should be between 6 and 12 characters long");
  } else if (!/[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]+/.test(this.user.pass.trim())) {
    alert("Password should contain at least one special character");
  } else if (!/[A-Z]/.test(this.user.pass.trim())) {
    alert("Password should contain at least one uppercase letter");
  } else if (!/[a-z]/.test(this.user.pass.trim())) {
    alert("Password should contain at least one lowercase letter");
  }else{

  this.userService.register(this.user).subscribe(
    (result) => {
      alert("user Registered successfully, Please login to continue")
      console.log("User registered successfully:", result);
    },
    (error) => {
      alert("user already exist")
      console.error("Registration failed:", error);
    }
  );
}
}


  // constructor(private http: HttpClient) { }

  // submit() {
  //   const url = 'http://localhost:8087/register'; // Replace with the actual URL
  //   this.http.post<any>(url, this.user).subscribe(
  //     (response) => {
  //       console.log('Registered user:', response);
  //     },
  //     (error) => {
  //       console.error('Error occurred:', error);
  //     }
  //   );
  // }
}

