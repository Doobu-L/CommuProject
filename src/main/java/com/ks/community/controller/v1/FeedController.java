package com.ks.community.controller.v1;

import com.ks.community.domain.dto.FeedDto;
import com.ks.community.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Feed", description = "피드관리 API")
@RequestMapping("/api/feed")
public class FeedController {
  private final FeedService feedService;

  @Operation(summary = "피드 추가", description = "")
  @PostMapping("/{userId}")
  public ResponseEntity newFeed(@PathVariable long userId,@RequestBody FeedDto req)
      throws Exception {
    return ResponseEntity.ok().body(feedService.newFeed(req,userId));
  }

  @Operation(summary = "피드리스트 조회", description = "")
  @GetMapping("")
  public ResponseEntity getFeedList(@PageableDefault(sort = "createTimestamp",direction = Direction.DESC) Pageable pageable){
    return ResponseEntity.ok().body(feedService.getFeedList(pageable));
  }

  @Operation(summary = "피드 조회", description = "")
  @GetMapping("/{id}")
  public ResponseEntity getFeed(@PathVariable long id) throws NotFoundException {
    return ResponseEntity.ok().body(feedService.getFeed(id));
  }

  @Operation(summary = "피드 수정", description = "")
  @PutMapping("/{id}")
  public ResponseEntity updateFeed(@PathVariable long id,@RequestBody FeedDto req)
      throws Exception {
    return ResponseEntity.ok().body(feedService.updateFeed(req,id));
  }



}
