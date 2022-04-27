package com.ks.community.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends Base{

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String nickName;

}
