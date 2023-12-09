import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {
  isUserLoggedIn = new BehaviorSubject<boolean>(false)

  url = 'http://localhost:8087/'
  constructor(private http: HttpClient,private router: Router) { }

  checkLogin(userName: string, pass: string) {
    const params = new HttpParams()
      .set('username', userName)
      .set('pass', pass);

    return this.http.post<boolean>(`${this.url}login`, params.toString(), {
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' } ,
      observe: 'response'
    }).subscribe((result)=>{
      if(result.body==true){
        this.isUserLoggedIn.next(true)
        localStorage.setItem("userLoggedIn",JSON.stringify(result.body));
        localStorage.setItem("user",JSON.stringify(userName));
        this.router.navigate([`search`])

      }else{
        alert("Not correct credentils");
      }
      console.warn("result",result.body);
    });

  }

  reloadUser(){
    if(localStorage.getItem('userLoggedIn')){
      console.log("hello")
      this.isUserLoggedIn.next(true)
      this.router.navigate([`search`])
    }
  }

  register(user:any){
    return this.http.post(`${this.url}register`,user)
  }

  logout(){
    return this.http.get("http://localhost:8087/logout")
  }
}
