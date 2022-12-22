package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entities.Chat;
import tn.esprit.spring.repositories.ChatRepository;

import java.util.List;

public class ChatService implements IChatService{
    @Autowired
    ChatRepository cr;
    @Override
    public Chat getChat(Long id) {
        return cr.findById(id).get();
    }

    @Override
    public List<Chat> getChats() {
        return (List<Chat>) cr.findAll();
    }

    @Override
    public Chat addChat(Chat c) {
        return cr.save(c);
    }

    @Override
    public Chat updateChat(Chat c) {
        return cr.save(c);
    }

    @Override
    public void deleteChat(Long id) {
        cr.deleteById(id);
    }
}
