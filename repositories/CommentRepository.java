package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.User;

import java.util.Set;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    Integer  countCommentByPost(Post p);
    Integer countCommentByUser(User user);
    @Query("select c.user from Comment c ")
    Set<User> activeUsers();
    @Query("select c.post from Comment c ")
    Set<Post> getPosts();
}
