package tn.esprit.spring.services;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.Rate;
import tn.esprit.spring.entities.User;

import java.util.Map;
import java.util.Set;

public interface IlikeService {
    public Rate makeLike(Long userId, Long postId);
    public Rate makeDislike(Long userId, Long postId);
    public void removeLike(Long userId,Long postID);
    public Map<Post,Integer> getPostLike();
    public Post mostLikedPost();
    public Set<Post> treeWithLike();
    public User mostReactedUser();
    public Set<Post> negativePosts();
    public int getNbLike(Post p);
    public int getNbDeslike(Post post);
    public Map<Post,Integer> getPostDeslike();

}
