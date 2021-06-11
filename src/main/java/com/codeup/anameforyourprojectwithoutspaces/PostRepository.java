package com.codeup.anameforyourprojectwithoutspaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findAll(String Table_leg1, String Table_leg2);
    Post findPostById(long id);
}
