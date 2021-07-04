package com.codeup.anameforyourprojectwithoutspaces.controllers;

import com.codeup.anameforyourprojectwithoutspaces.daos.PostRepository;
import com.codeup.anameforyourprojectwithoutspaces.daos.UsersRepository;
import com.codeup.anameforyourprojectwithoutspaces.models.EmailService;
import com.codeup.anameforyourprojectwithoutspaces.models.Post;
import com.codeup.anameforyourprojectwithoutspaces.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;
    private UsersRepository usersDao;
    private final EmailService emailService;

    public PostController(PostRepository postRepository, UsersRepository usersRepository, EmailService emailService){
        postDao = postRepository;
        usersDao = usersRepository;
        this.emailService = emailService;
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
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @GetMapping("/redirect-me")
    public String redirect() {
        return "redirect:/about";
    }

    @PostMapping("/posts/create")
    public String save(@ModelAttribute Post newPost){
        emailService.prepareAndSend(newPost, "[SUBJECT LINE SAMPLE TEXT]", String.format("[BODY %s %s]", newPost.getTitle(), newPost.getDescription()));
        User user = usersDao.getById(1L);
        newPost.setOwner(user);
        Post savedPost = postDao.save(newPost);
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

//    @GetMapping("/search")
//    public String searchResults(Model model, @RequestParam(name = "term") String term){
//        List<Post> posts = postDao.searchByTitle(term);
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }

}
