import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service'; 


@Component({
  selector: 'app-post-create',
  templateUrl: './post-create.component.html',
  styleUrls: ['./post-create.component.css']
})
export class PostCreateComponent implements OnInit {

  constructor(private postService : PostService) { }

  

  ngOnInit(): void {
  }

  p_title: string;
  p_place: string;
  p_note: string;
  message: string;

  publish() : void {
    var params = {'title':this.p_title, 'place':this.p_place, 'note':this.p_note, 'created_by':Number.parseInt(localStorage.getItem('id'))};
    console.log(params);
    this.postService.createPost(params)
      .subscribe(any => {
        console.log(any);
        console.log("Post successfully created!");
        this.message = "Travel post successfully created." ;
      },
        error => {
          // Print an error message here!.
          console.log(error);
          this.message = "Something went wrong! Travel post couldn't created!";
        });
  }

}
