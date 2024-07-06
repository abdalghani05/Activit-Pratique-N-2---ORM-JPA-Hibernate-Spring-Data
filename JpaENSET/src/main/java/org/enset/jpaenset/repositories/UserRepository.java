package org.enset.jpaenset.repositories;

import org.enset.jpaenset.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findUserByUserName(String userName);

}
