package tn.esprit.spring.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.services.PostService;

import java.util.List;
@RestController
@Api(tags = "Post")
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService ps;
    @GetMapping("/get/{id}")
    @ResponseBody
    public Post getPost(@PathVariable("id") Long id) {
        return ps.getPost(id);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Post> getPosts() {
        return (List<Post>) ps.getPosts();
    }
    @PostMapping("/add/{id}")
    @ResponseBody
    public Post addPost(@RequestBody Post p, @PathVariable("id") Long id) {
        return ps.addPost(p,id);
    }
    @PutMapping("/update")
    @ResponseBody
    public Post updatePost(@RequestBody Post p) {
        return ps.updatePost(p);
    }
    @DeleteMapping("/delete/{id}")

    public void deletePost(@PathVariable("id") Long id) {
        ps.deletePost(id);
    }
}
