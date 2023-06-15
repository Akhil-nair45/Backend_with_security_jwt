package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import java.util.Optional;

@Service
public class UserServImpl implements UserServ {

	
	@Autowired
	private UserRepo ur;
	
	@Override
	public User saveuser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		System.out.println(user);
//		return null;
		return ur.save(user);
	}

	@Override
	public List<User> findAllusers() {
		return ur.findAll();
	}

	@Override
	public User getByid(int id) {
		Optional<User> userfromdatabase= ur.findById(id);
		if(userfromdatabase.get().getIsDeleted() == 1) {
			return null;
		}
		return userfromdatabase.get();
	}

	@Override
	public ResponseEntity<String> deleteuser(Integer id) {
		Optional<User> user=ur.findById(id);
		if(user.isPresent())
		{
			User u= user.get();
			u.setIsDeleted(1);
			ur.save(u);
			return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}
	}

	@Override
	public boolean validate(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User userFromDatabase = ur.findByEmail(user.getEmail());
		if(userFromDatabase.getIsDeleted() == 1) return false;
		else {
			if(userFromDatabase==null) return false;
			if(passwordEncoder.matches(user.getPassword(),userFromDatabase.getPassword())) return true;
			return false;
		}

	}

	@Override
	public List<User> findByNotMarkedAsDeleted() {
		// TODO Auto-generated method stub
		return ur.findByNotMarkedAsDeleted();
	}
}
