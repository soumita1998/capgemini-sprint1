package com.cg.bookmydoctor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exceptions.InValidIdException;
import com.cg.bookmydoctor.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	@Qualifier("service")
	private IUserService usserv;
	
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getALL()
	{
		List<User> list = new ArrayList<User>();
		list = usserv.getAll();
		if(list.size() == 0)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.ok(list); //returns 200 OK httpstatus
	}
	
	@GetMapping("/fetchbyid/{userId}")
	public User fetchById(@PathVariable("userId") int userId)
	{
		return usserv.fetchById(userId);
		
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) //returns ResponseEntity object 
	{
		
		//uss.addUser(user);
		//return ResponseEntity.of(Optional.of(user));//shows the user details that has been inserted in output
		User usersaved=usserv.addUser(user);
		return new ResponseEntity<User>(usersaved,HttpStatus.CREATED);
		//status 201 created as 
		//as well as new user details shown
			
	}
	
	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @Valid @RequestBody User user) throws Exception
	{
		
			usserv.updateUser(userId,user);
			return ResponseEntity.of(Optional.of(user));//shows the updated user details
			
		
		
	}
	


	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String>  removeUser(@PathVariable int userId)
	{
		
		usserv.removeUser(userId);
			
		return ResponseEntity.of(Optional.of("deleted the entry"));//shows "updated" message in the output
		
	}
	
	@GetMapping("/userbyrole/{role}")
	public ResponseEntity<List<User>> getByRole(@PathVariable String role) 
	{
		List<User> list = new ArrayList<User>();
		list = usserv.getByRole(role);
		if(list.size() == 0)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.ok(list); //returns 200 OK httpstatus
	
		
	}
	


}
