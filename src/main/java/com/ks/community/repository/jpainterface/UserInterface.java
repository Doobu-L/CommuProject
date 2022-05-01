package com.ks.community.repository.jpainterface;


import com.ks.community.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User,Long> {

}
