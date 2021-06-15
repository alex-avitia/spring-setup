package com.codeup.anameforyourprojectwithoutspaces.controllers;

import com.codeup.anameforyourprojectwithoutspaces.daos.PostRepository;
import com.codeup.anameforyourprojectwithoutspaces.daos.UsersRepository;
import com.codeup.anameforyourprojectwithoutspaces.models.Post;
import com.codeup.anameforyourprojectwithoutspaces.models.User;
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

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String save(@ModelAttribute Post post){
        User user = usersDao.getById(1L);
        post.setOwner(user);
        Post savedPost = postDao.save(post);
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id){
        Post postToEdit = postDao.getById(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    @ResponseBody
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "description") String description){
        // find post
        Post foundPost = postDao.getById(id);
        // edit post
        foundPost.setTitle(title);
        foundPost.setDescription(description);
        // save changes
        postDao.save(foundPost);
        return "post updated";
    }

    @PostMapping("/posts/{id}/delete")
    public String destroy(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/search")
    public String searchResults(Model model, @RequestParam(name = "term") String term){
        List<Post> posts = postDao.searchByTitle(term);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

}
