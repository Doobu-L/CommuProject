package com.ks.community.domain.dto;

import com.ks.community.domain.entity.User;
import com.ks.community.enumtype.Role;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OAuthAttributes {
  private Map<String, Object> attributes;
  private String nameAttributeKey;
  private String username;
  private String nickname;
  private String email;
  private String code;
  private Role role;
  public static OAuthAttributes of(String registrationId,
      String userNameAttributeName,
      Map<String, Object> attributes) {
    /* 구글인지 네이버인지 카카오인지 구분하기 위한 메소드 (ofNaver, ofKaKao) */
    return ofGoogle(userNameAttributeName, attributes);
  }
  private static OAuthAttributes ofGoogle(String userNameAttributeName,
      Map<String, Object> attributes) {
    return OAuthAttributes.builder()
        .username((String) attributes.get("email"))
        .email((String) attributes.get("email"))
        .nickname((String) attributes.get("name"))
        .code((String)attributes.get("code"))
        .attributes(attributes)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }
  public User toEntity() {
    return User.builder()
        .username(email)
        .email(email)
        .nickname(nickname)
        .role(Role.SOCIAL)
        .build();
  }
}