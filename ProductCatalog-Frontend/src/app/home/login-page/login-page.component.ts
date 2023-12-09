import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserApiService } from 'src/app/services/user-api.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.sass']
})
export class LoginPageComponent {
uname:string=''
pass:string=''

constructor(private router: Router, private userService: UserApiService) { }


// submit() {
//   this.userService.checkLogin(this.uname, this.pass).subscribe((result) => {
//     console.log(result)
//     if (result) {
//       this.router.navigate([`search`])
//     } else {
//       console.log("Wrong Credentials");
//     }
//   });
  

// }

submit() {
  this.userService.checkLogin(this.uname, this.pass)
}
}
