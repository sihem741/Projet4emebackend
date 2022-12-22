package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;
@Service

public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;
	@Override
	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User u) {
		userRepository.save(u);
		return u;
	}

	@Override
	public void deleteUser(Long Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUser(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doHashing(String psw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveImage(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

}
