package com.codeup.anameforyourprojectwithoutspaces.controllers;

import com.codeup.anameforyourprojectwithoutspaces.daos.PostRepository;
import com.codeup.anameforyourprojectwithoutspaces.daos.UsersRepository;
import com.codeup.anameforyourprojectwithoutspaces.models.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PostController {

    private PostRepository postDao;
    private UsersRepository usersDao;

    public PostController(PostRepository postRepository, UsersRepository usersRepository){
        postDao = postRepository;
        usersDao = usersRepository;
    }

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> postsList = postDao.findAll();
        model.addAttribute("noPostsFound", postsList.size() == 0);
        model.addAttribute("posts", postsList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("postId", id);
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @RequestMapping(name = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreate() {
        return "view the form for creating a post";
    }

    @RequestMapping(name = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }

}
