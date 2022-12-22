package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Chat;
import tn.esprit.spring.entities.Comment;
@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {
}
