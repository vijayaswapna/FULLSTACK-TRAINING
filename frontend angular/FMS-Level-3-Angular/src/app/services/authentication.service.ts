import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.component';

//Author: Vijaya Swapna
//Description: Performs Authentication and user management operations
//Created On: 08/05/2020


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  //Retrieves user token and checks authentication
  authenticate(username, password) {

    return this.httpClient.post<any>('https://localhost:9092/api/auth',
    {username, password}).subscribe(
      userData => {
        sessionStorage.setItem('username', username);
        let tokenStr = 'Bearer' +userData.token;
        sessionStorage.setItem('token', tokenStr);
        return userData;
      }
    );
  }

  // Checks whether the user is logged in
  isUserLoggedIn():boolean {
    let user = sessionStorage.getItem('username')
    return (user !== null)
  }

  // Removes user session(logout)
  logOut() {
    sessionStorage.removeItem('username');
  }

  // Retrives role of user(customer/admin)
  getRole(username:string) {
    return this.httpClient.get('https://localhost:9092/getRole?username='+ username);
  }

  // Adds a new User
  signUp(user: User) {
    return this.httpClient.post('https://localhost:9092/signup', user);

  }


}
