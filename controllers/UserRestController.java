package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserRestController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {
		String pass = u.getPwd();
		u.setPwd(pass);
		u.setUrlpicture("user.png");
		return userService.addUser(u);
	}
}
