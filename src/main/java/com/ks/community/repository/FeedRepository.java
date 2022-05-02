package com.ks.community.repository;

import com.ks.community.dto.FeedDto;
import com.ks.community.entity.Feed;
import com.ks.community.entity.User;
import com.ks.community.repository.jpainterface.FeedInterface;
import com.ks.community.repository.jpainterface.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class FeedRepository {

  private final FeedInterface feedInterface;
  private final UserInterface userInterface;

  public Feed insertFeed(FeedDto feedDto,long userId) throws Exception {
      User user = userInterface.findById(userId).orElseThrow(IllegalAccessException::new);
      if(feedDto==null)
        throw new IllegalAccessException();
      Feed feed = new Feed(feedDto,user);
      feed = feedInterface.save(feed);
    return feed;
  }

}
