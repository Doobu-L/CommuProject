package com.ks.community.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ks.community.domain.dto.UserDto;
import com.ks.community.enumtype.OAuthType;
import com.ks.community.enumtype.Role;
import java.util.List;
import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Column
    private String userId;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column
    private OAuthType oauthType;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JsonIgnore
    private List<Feed> feedList;

    public User(UserDto dto){
        this.username = dto.getUsername();
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
    }

    public String getRoleValue(){
        return this.role.getValue();
    };

    public User updateModifiedDate() {
        this.onUpdate();
        return this;
    }

    @Builder
    public User(String userId,String username,String email,String password,String nickname,Role role){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }
}
