import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private httpClient: HttpClient) { 

    }


  getAuthenticationToken(username:string, password:string) : Observable<any> {

    // If you see CORS error. You have to use httpOptions here.
    return this.httpClient.post<any>(
      "http://0.0.0.0:8000/api-token-auth/", 
      {'username':username, 'password':password});
  }

  isAuthTokenValid() : boolean {
    return false;
  }
}
