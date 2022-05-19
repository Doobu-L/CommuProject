package com.ks.community.repository.jpainterface;


import com.ks.community.domain.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User,Long> {

  Optional<User> findByEmail(String email);


  Optional<User> findByUserId(String userId);

  Optional<User> findByNickname(String nickname);
}
