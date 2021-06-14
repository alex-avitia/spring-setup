package com.codeup.anameforyourprojectwithoutspaces.daos;

import com.codeup.anameforyourprojectwithoutspaces.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("from Post as p where p.title like %:term% or p.description like %:term%")
    List<Post> searchByTitle(@Param("term") String term);
}
