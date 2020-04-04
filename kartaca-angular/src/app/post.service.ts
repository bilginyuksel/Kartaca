import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Post } from './post';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';




@Injectable({
  providedIn: 'root'
})
export class PostService {
  

  constructor(
    private httpClient: HttpClient) { } 

  header = {headers: new HttpHeaders().set('Authorization','JWT '+ localStorage.getItem('token'))};


  createPost(params): void {

    let par = {headers: this.header, param:params};
    this.httpClient.post<any>('http://localhost:8000/api/agenda',par);
  }
    
  getPosts() : Observable<Post[]> {
    


    return this.httpClient.get<any>("http://localhost:8000/api/agenda",this.header);
  }

  getPost(id: number) : Observable<Post> {

    /**
     * I also need to set Authorization Header with this request.
     * Or maybe if i can configure basic authentication it will be OK.
     * this.httpClient.get<any>("localhost:8000/api/agenda", {'Authorization': 'JWT KEY'})
      .subscribe(any => console.log(any));
     */
    let endpoint = "http://localhost:8000/api/agenda/"+id.toString();
    return this.httpClient.get<any>(endpoint, this.header);
   }
}
