package com.ks.community.entity;

import com.ks.community.dto.UserDto;
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

    public User(UserDto dto){
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.nickName = dto.getNickname();
    }
}
