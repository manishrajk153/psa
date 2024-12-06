package com.mappingfeb2.controller;

import com.mappingfeb2.entity.Comment;
import com.mappingfeb2.entity.Post;
import com.mappingfeb2.repository.CommentRepository;
import com.mappingfeb2.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private CommentRepository commentRepository;

    private PostRepository postRepository;

    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(
            @RequestBody Comment comment,
            @RequestParam long postId
    ){
        Post post=postRepository.findById(postId).get();
        comment.setPost(post);
        return ResponseEntity.ok(commentRepository.save(comment));
    }

}
