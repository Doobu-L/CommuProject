package com.ks.community.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class BaseEntityDto {
  protected Long id;
  protected String delYn;
  protected LocalDateTime updateTimestamp;
  protected LocalDateTime createTimestamp;

}
