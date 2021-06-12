package com.codeup.anameforyourprojectwithoutspaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findAll(String title);

    Post findByBody(String body);
}
