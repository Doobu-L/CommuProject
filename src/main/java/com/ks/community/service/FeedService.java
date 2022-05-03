package com.ks.community.service;

import com.ks.community.dto.FeedDto;
import com.ks.community.entity.Feed;
import com.ks.community.repository.FeedRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedService {
  private final FeedRepository feedRepository;

  @Transactional
  public Feed newFeed(FeedDto req,long userId) throws Exception {
    return feedRepository.insertFeed(req,userId);
  }

  public List<FeedDto> getFeedList(Pageable pageable){
    return feedRepository.getFeedList(pageable).getContent().stream().map(FeedDto::new).collect(
        Collectors.toList());
  }

  public FeedDto getFeed(long id) throws NotFoundException {
    return feedRepository.getFeedById(id).map(FeedDto::new).orElseThrow(NotFoundException::new);
  }
}
