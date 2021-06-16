package com.codeup.anameforyourprojectwithoutspaces.daos;

import com.codeup.anameforyourprojectwithoutspaces.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}