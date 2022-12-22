package tn.esprit.spring.services;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.User;

import java.util.List;

public interface ICommentService {
    public Comment getComment(Long id);
    public List<Comment> getComments();
    public Comment addComment(Comment c,Long idu,Long idp);
    public Comment updateComment(Comment c);
    public void deleteComment(Long id);
    public Post mostCommentedPost();
    public User mostActiveUser();
    public int getNbComment(Long idPost);



}
