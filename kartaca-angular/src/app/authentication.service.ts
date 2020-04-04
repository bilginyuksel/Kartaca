import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private httpClient: HttpClient) { }

  getAuthenticationToken() : Observable<String> {

    // If you see CORS error. You have to use httpOptions here.
    return this.httpClient.post<String>("http://localhost:8000/api-token-auth", 
      {'username':'bilginyuksel', 'password':'raistlin1978'});
    // return of("key");
  }

  isAuthTokenValid() : boolean {
    return false;
  }
}
