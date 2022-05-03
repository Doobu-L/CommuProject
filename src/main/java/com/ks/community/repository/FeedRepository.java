package com.ks.community.repository;

import com.ks.community.dto.FeedDto;
import com.ks.community.entity.Feed;
import com.ks.community.entity.User;
import com.ks.community.repository.jpainterface.FeedInterface;
import com.ks.community.repository.jpainterface.UserInterface;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FeedRepository {

  private final FeedInterface feedInterface;
  private final UserInterface userInterface;

  public Feed insertFeed(FeedDto feedDto, long userId) throws Exception {
    User user = userInterface.findById(userId).orElseThrow(IllegalAccessException::new);
    if (feedDto == null) {
      throw new IllegalAccessException();
    }
    Feed feed = new Feed(feedDto, user);
    feed = feedInterface.save(feed);
    return feed;
  }

  public List<FeedDto> getFeedList(Pageable pageable) {
    return feedInterface.findAll(pageable).stream().map(FeedDto::new).collect(Collectors.toList());
  }

}
