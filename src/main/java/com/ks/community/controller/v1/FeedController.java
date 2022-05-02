package com.ks.community.controller.v1;

import com.ks.community.dto.FeedDto;
import com.ks.community.service.FeedService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Feed", description = "피드관리 API")
@RequestMapping("/feed")
public class FeedController {
  private final FeedService feedService;

  @PostMapping("/{userId}")
  public ResponseEntity newFeed(@PathVariable long userId,@RequestBody FeedDto req)
      throws Exception {
    return ResponseEntity.ok().body(feedService.newFeed(req,userId));
  }

}
