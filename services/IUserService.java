package tn.esprit.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.User;

public interface IUserService {
	List<User> retrieveAllUsers();
    User addUser(User u);
	void deleteUser(Long Id);
	User updateUser(User u);
	User retrieveUser(Long Id);
	public String doHashing(String psw);
	public void saveImage(MultipartFile  file);
}
