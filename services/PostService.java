package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.PostRepository;
import tn.esprit.spring.repositories.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService implements IPostService{
    @Autowired
    PostRepository pr;
    @Autowired
    UserRepository ur;
    @Override
    public Post getPost(Long id) {
        return pr.findById(id).get();
    }

    @Override
    public List<Post> getPosts() {
        return (List<Post>) pr.findAll();
    }

    @Override
    public Post addPost(Post p, Long id) {
        User user=ur.findById(id).get();
        p.setUser(user);
        p.setDate(new Date());
        return pr.save(p);
    }

    @Override
    public Post updatePost(Post p) {
        return pr.save(p);
    }

    @Override
    public void deletePost(Long id) {
       pr.deleteById(id);
    }
}
