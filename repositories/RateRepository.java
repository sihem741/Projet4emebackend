package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.Rate;
import tn.esprit.spring.entities.RateId;
import tn.esprit.spring.entities.User;

import java.util.List;
import java.util.Set;

@Repository
public interface RateRepository extends JpaRepository<Rate, RateId> {
    @Query("select count(R) from Rate R  where R.value=true and R.rateId.post= :post")
    public Integer countnblike(@Param("post") Post post);
    @Query("select count(R) from Rate R  where R.value=false and R.rateId.post= :post")
    public Integer countnbDeslike(@Param("post") Post post);
    @Query("select R.rateId.post from Rate R")
    Set<Post> getReactedPosts();
    @Query("select count(R) from Rate R  where R.rateId.user= :user")
    public Integer countLikeParUser(@Param("user") User user);
    @Query("select R.rateId.user from Rate R")
    List<User> getActiveUsers();

}
