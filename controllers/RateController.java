package tn.esprit.spring.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.Rate;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.PostRepository;
import tn.esprit.spring.services.RateService;

import java.util.Map;
import java.util.Set;

@RestController
@Api(tags = "rate")
@RequestMapping("/rate")
public class RateController  {
   @Autowired
    RateService rs;
   @Autowired
    PostRepository pr;
   @PostMapping("/{idu}/like/{idp}")
   @ResponseBody
    public Rate makeLike(@PathVariable("idu")Long  userId,@PathVariable("idp") Long postId) {
        return rs.makeLike(userId,postId);
    }

    @PostMapping("/{idu}/dislike/{idp}")
    @ResponseBody
    public Rate makeDislike(Long userId, Long postId) {
        return rs.makeDislike(userId,postId);
    }

    @DeleteMapping("/{idu}/remove/{idp}")
    @ResponseBody
    public void removeLike(Long userId, Long postID) {
      rs.removeLike(userId,postID);
    }
    @GetMapping("/mostliked")
    @ResponseBody
    public Post mostLikedPost() {
        return rs.mostLikedPost();
    }
    @GetMapping("/tree")
    @ResponseBody
    public Set<Post> treeWithLike() {
        return rs.treeWithLike();
    }

     @GetMapping("/mostActiveUser")
    public User mostReactedUser() {
        return rs.mostReactedUser();
    }

    @GetMapping("/negative")
    @ResponseBody
    public Set<Post> negativePosts() {
        return rs.negativePosts();
    }

    @GetMapping("/nblike/{idP}")
    @ResponseBody
    public int getNbLike(@PathVariable("idP") long id) {
       Post post=pr.findById(id).get() ;
       if(post!=null)
           return rs.getNbLike(post);
       return 0;
    }
    @GetMapping("/nbDeslike/{idP}")
    @ResponseBody
    public int getNbDesLike(@PathVariable("idP") long id) {
        Post post=pr.findById(id).get() ;
        if(post!=null)
            return rs.getNbDeslike(post);
        return 0;
    }
    @GetMapping("/post/like")
    @ResponseBody
    public Map<Post,Integer> getPostLike() {
        return rs.getPostLike();
    }
    @GetMapping("/post/deslike")
    @ResponseBody
    public Map<Post,Integer> getPostDesLike() {
        return rs.getPostLike();
    }
}
