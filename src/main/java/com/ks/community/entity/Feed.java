package com.ks.community.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ks.community.dto.FeedDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter@Setter@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  @Column
  private String title;

  @Column()
  private String content;

  public Feed(FeedDto dto,User user){
    this.user = user;
    if(StringUtils.isNotBlank(dto.getTitle()))this.title=dto.getTitle();
    if(StringUtils.isNotBlank(dto.getContent()))this.content=dto.getContent();
  }


}
