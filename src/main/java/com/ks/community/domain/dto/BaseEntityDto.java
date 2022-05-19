package com.ks.community.domain.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseEntityDto {
  protected Long id;
  protected String delYn;
  protected LocalDateTime updateTimestamp;
  protected LocalDateTime createTimestamp;

}
