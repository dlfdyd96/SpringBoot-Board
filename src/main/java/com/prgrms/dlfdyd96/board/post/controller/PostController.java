package com.prgrms.dlfdyd96.board.post.controller;

import com.prgrms.dlfdyd96.board.common.api.ApiResponse;
import com.prgrms.dlfdyd96.board.post.dto.CreatePostRequest;
import com.prgrms.dlfdyd96.board.post.dto.PostResponse;
import com.prgrms.dlfdyd96.board.post.dto.UpdatePostRequest;
import com.prgrms.dlfdyd96.board.post.service.PostService;
import javassist.NotFoundException;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping("/posts")
  @ResponseStatus(HttpStatus.CREATED)
  public ApiResponse<Long> create(@RequestBody @Valid CreatePostRequest createPostRequest)
      throws NotFoundException {
    return ApiResponse.ok(postService.save(createPostRequest));
  }

  @GetMapping("/posts")
  public ApiResponse<Page<PostResponse>> getAll(Pageable pageable) {
    return ApiResponse.ok(postService.findPosts(pageable));
  }

  @GetMapping("/posts/{id}")
  public ApiResponse<PostResponse> getOne(@PathVariable Long id) throws NotFoundException {
    return ApiResponse.ok(postService.findOne(id));
  }

  @PutMapping("/posts/{id}")
  public ApiResponse<PostResponse> update(@PathVariable Long id,
      @RequestBody @Valid UpdatePostRequest updatePostRequest) throws Exception {
    return ApiResponse.ok(postService.update(id, updatePostRequest));
  }

  @DeleteMapping("/posts/{id}")
  public ApiResponse<Integer> delete(@PathVariable Long id) throws NotFoundException {
    postService.delete(id);
    Integer affectedItem = 1;

    return ApiResponse.ok(affectedItem);
  }
}
