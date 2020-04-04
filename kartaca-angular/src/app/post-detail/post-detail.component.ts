import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import { ActivatedRoute } from '@angular/router';
import { PostService } from '../post.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
    private location: Location) { }

  post: Post;

  ngOnInit(): void {
    this.getPost();
  }


  getPost() : void {
    const id =  +this.route.snapshot.paramMap.get('id');
    this.postService.getPost(id)
      .subscribe(post => this.post = post);
  }

  goBack() : void {
    this.location.back();
  }

}
