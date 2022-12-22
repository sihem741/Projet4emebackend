package tn.esprit.spring.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.CommentService;

import java.util.List;

@RestController
@Api(tags = "comment")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService cs;
   @GetMapping("/get/{id}")
   @ResponseBody
    public Comment getComment(@PathVariable("id") Long id) {
        return cs.getComment(id);
    }
    @GetMapping("/get")
    @ResponseBody

    public List<Comment> getComments() {
        return cs.getComments();
    }
    @PutMapping("/update")
    @ResponseBody
    public Comment updateComment(@RequestBody Comment c) {
       return cs.updateComment(c);

    }
    @PostMapping("/{idu}/add/{idp}")
    @ResponseBody
    public Comment addComment(@RequestBody Comment c,@PathVariable("idu")Long idu,@PathVariable("idp")Long idp) {
        return cs.addComment(c,idu,idp);
    }

    @DeleteMapping("delete/{idc}")
    public void deleteComment(@PathVariable("idc") Long idc) {
        cs.deleteComment(idc);
    }
    @GetMapping("/topCommentedPost")
    @ResponseBody
    public Post mostCommentedPost() {
        return cs.mostCommentedPost();
    }
    @GetMapping("/ActiveUser")
    @ResponseBody
    public User mostActiveUser() {
        return cs.mostActiveUser();
    }

    @GetMapping("/nbComment/{id}")
    @ResponseBody
    public int getNbComment(@Param("id") Long idPost) {
        return cs.getNbComment(idPost);
    }
}
