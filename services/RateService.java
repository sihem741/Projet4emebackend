package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.Rate;
import tn.esprit.spring.entities.RateId;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.PostRepository;
import tn.esprit.spring.repositories.RateRepository;
import tn.esprit.spring.repositories.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RateService implements IlikeService{
    @Autowired
    RateRepository rr;
    @Autowired
    UserRepository ur;
    @Autowired
    PostRepository pr;
    @Override
    public Rate makeLike(Long userId, Long postId) {
        Rate rate =new Rate();
        RateId rd =new RateId();
        rd.setPost(pr.findById(postId).orElse(null));
        rd.setUser(ur.findById(userId).orElse(null));
        rate.setRateId(rd);
        rate.setValue(true);
        return rr.save(rate);
    }

    @Override
    public Rate makeDislike(Long userId, Long postId) {
        Rate rate =new Rate();
        RateId rd =new RateId();
        rd.setPost(pr.findById(postId).orElse(null));
        rd.setUser(ur.findById(userId).orElse(null));
        rate.setRateId(rd);
        rate.setValue(false);
        return rr.save(rate);
    }

    @Override
    public void removeLike(Long userId, Long postId) {
        RateId rd =new RateId();
        rd.setPost(pr.findById(postId).orElse(null));
        rd.setUser(ur.findById(userId).orElse(null));
        rr.deleteById(rd);
    }

    @Override
    public Map<Post,Integer> getPostLike(){
        Map<Post,Integer> map=new HashMap<>();
        Set<Post> posts=rr.getReactedPosts();
        posts.forEach(p->map.put(p,rr.countnblike(p)));
        return map;
    }


    @Override
    public Post mostLikedPost() {
        Set<Post> posts=rr.getReactedPosts();
       return  posts.stream().max((p,v)->rr.countnblike(p)-rr.countnblike(v)).orElse(null);

    }

    @Override
    public Set<Post> treeWithLike() {
        Set<Post> posts=rr.getReactedPosts();
        return  posts.stream().sorted((v,p)->rr.countnblike(p)-rr.countnbDeslike(v)).collect(Collectors.toSet());
    }

    @Override
    public User mostReactedUser() {
        List<User> users=rr.getActiveUsers();
        return users.stream().max((p,v)->rr.countLikeParUser(p)-rr.countLikeParUser(v)).orElse(null);
    }

    @Override
    public Set<Post> negativePosts() {
        Set<Post> posts=rr.getReactedPosts();
        return posts.stream().filter(p->rr.countnblike(p)<rr.countnbDeslike(p)).collect(Collectors.toSet());
    }

    @Override
    public int getNbLike(Post p) {
        if(rr.countnblike(p)!=0)
        return  rr.countnblike(p);
        return 0;
    }

    @Override
    public int getNbDeslike(Post post) {

        if(rr.countnbDeslike(post)!=0)
            return rr.countnbDeslike(post);
        return 0;
    }

    @Override
    public Map<Post, Integer> getPostDeslike() {
        Map<Post,Integer> map=new HashMap<>();
        Set<Post> posts=rr.getReactedPosts();
        posts.forEach(p->map.put(p,rr.countnbDeslike(p)));
        return map;
    }
}
