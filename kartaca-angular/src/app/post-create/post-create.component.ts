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

  title: string;
  place: string;
  note: string;
  message: string;

  publish() : void {
    var params = {'title':this.title, 'place':this.place, 'note':this.note};
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
