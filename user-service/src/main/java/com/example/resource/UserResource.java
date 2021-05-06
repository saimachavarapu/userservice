package com.example.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.user;
import com.example.repository.UserRepository;



@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<user> getAllUsers(){
		return userRepository.findAll();	
	}
	//@GetMapping("/Users/{id}")
//	public ResponseEntity<Optional<user>> getUserById(@PathVariable Long id){
//		Optional<user> user= userRepository.findById(id);
	//	return new ResponseEntity<>(user,HttpStatus.FOUND);
//	}
	
	
	//@GetMapping("/Users/address/{address}")
//	public ResponseEntity<List<user>> getUserByAddress(@PathVariable String address){
//		List<user> user= userRepository.findByAddress(address);
//		return new ResponseEntity<>(user,HttpStatus.FOUND);
//	}

	@GetMapping("/users/{id}")
    public Optional<user> getUserById(@PathVariable Long id){
    	return userRepository.findById(id);
    }
    
    @GetMapping("/users/name/{username}")
    public Optional<user> getUserByName(@PathVariable String  username){
    	return userRepository.findByUsername(username);
    }
    @DeleteMapping("/users/{id}")
    public void deletUser(@PathVariable long id) {
   	userRepository.deleteById(id);
   }
    
    @PostMapping
    public user createUser(@RequestBody user user) {
   	user savedUser = userRepository.save(user);
   	return  savedUser;
   }
}
