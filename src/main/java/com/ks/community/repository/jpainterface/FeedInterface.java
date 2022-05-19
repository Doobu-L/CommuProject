package com.ks.community.repository.jpainterface;


import com.ks.community.domain.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedInterface extends JpaRepository<Feed,Long> {

}
