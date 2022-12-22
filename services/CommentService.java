package tn.esprit.spring.services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.CommentRepository;
import tn.esprit.spring.repositories.PostRepository;
import tn.esprit.spring.repositories.UserRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
@Slf4j
@Service
public class CommentService implements ICommentService {

    @Autowired
    CommentRepository cr;
    @Autowired
    UserRepository ur;
    @Autowired
    PostRepository pr;
    @Autowired
    BadWords bw;
    @Override
    public Comment getComment(Long id) {
        return cr.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getComments() {
        return (List<Comment>) cr.findAll();
    }

    @Override
    public Comment addComment(Comment c,Long idU,Long idP) {


        try {
            if(BadWords.verfiyWord(c.getContents())) {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user=ur.findById(idU).orElse(null);
        Post post=pr.findById(idP).orElse(null);
        c.setUser(user);
        c.setPost(post);
        return cr.save(c);
    }

    @Override
    public Comment updateComment(Comment c) {
        return cr.save(c);
    }

    @Override
    public void deleteComment(Long id) {
        cr.deleteById(id);
    }

    @Override
    public Post mostCommentedPost() {
        Set<Post> posts=cr.getPosts();
        return posts.stream().max((c1,c2)->cr.countCommentByPost(c1)-cr.countCommentByPost(c2)).orElse(null);
    }

    @Override
    public User mostActiveUser() {
        Set<User> users=cr.activeUsers();
        return users.stream().max((c1,c2)-> cr.countCommentByUser(c1)-cr.countCommentByUser(c2)).orElse(null);
    }
    @Override
    public int getNbComment(Long idPost) {
         Post p= pr.findById(idPost).orElse(null);
         if(p!=null)
        return cr.countCommentByPost(p);
         return 0;
    }
}
