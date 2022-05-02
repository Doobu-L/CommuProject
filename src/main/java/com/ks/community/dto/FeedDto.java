package com.ks.community.dto;

import com.ks.community.entity.Feed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter@ToString(callSuper = true)
@NoArgsConstructor
public class FeedDto extends BaseEntityDto {

  private String title;
  private String content;

  public FeedDto(Feed feed){
    this.id = feed.getId();
    this.delYn = feed.getDelYn();
    this.updateTimestamp = feed.getUpdateTimestamp();
    this.createTimestamp = feed.getCreateTimestamp();
    this.title = feed.getTitle();
    this.content = feed.getContent();
  }

}
