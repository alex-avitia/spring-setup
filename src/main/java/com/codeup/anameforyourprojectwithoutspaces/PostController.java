package com.codeup.anameforyourprojectwithoutspaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class PostController<postRepository> {

    private final postRepository postDao;

    public PostController(postRepository postDao) {

        this.postDao = postDao;
    }

    @GetMapping(path= "/posts")
    @ResponseBody
    public String indexPage() {
        return "posts index page";
    }

    @RequestMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable int id) {
        return "view an individual post";
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

    @PostMapping(path="/posts")
    @ResponseBody
    public String postPost(@RequestParam(name="post") String post, Model model) {
        return "post";
    }

}
