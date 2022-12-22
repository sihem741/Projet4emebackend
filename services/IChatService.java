package tn.esprit.spring.services;

import tn.esprit.spring.entities.Chat;

import java.util.List;

public interface IChatService {
    public Chat getChat(Long id);
    public List<Chat> getChats();
    public Chat addChat(Chat c);
    public Chat updateChat(Chat c);
    public void deleteChat(Long id);
    
}
