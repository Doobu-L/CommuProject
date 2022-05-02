package com.ks.community.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ks.community.dto.UserDto;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String nickName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JsonIgnore
    private List<Feed> feedList;

    public User(UserDto dto){
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.nickName = dto.getNickname();
    }
}
