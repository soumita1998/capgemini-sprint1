package com.cg.bookmydoctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dao.IUserRepository;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exceptions.InValidIdException;
import com.cg.bookmydoctor.exceptions.NotValidException;
@Service("service")
public class IUserServiceImp implements IUserService 
{
	@Autowired
	@Qualifier("reposi")
	private IUserRepository usrep;
	
	public boolean validateUser(User user)
	{
		String passwordRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$";
		String usernameRegex="^[A-Za-z]\\w{5,30}$";
		Pattern p=Pattern.compile(passwordRegex);
		Pattern p1=Pattern.compile(usernameRegex);
		if((p.matcher(user.getPassword()).matches()) && (p1.matcher(user.getUserName()).matches()) )
		{
			return true;
		}
		else {
			return false;
		}
	}
	public User addUser(User user)
	{
		if(validateUser(user))
			return usrep.save(user);
		else {
			throw new NotValidException("username or password not valid");
		}
		
		
	}
	public void removeUser(int userId)
	{
		 usrep.deleteById(userId);
		  
	}
	public User updateUser(int userId,User user)
	{
		
	    
		if(validateUser(user))
		{
			User userDb = usrep.findById(userId).get();

			if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) 
			{
				userDb.setUserName(user.getUserName());
			}
			if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) 
			{
				userDb.setPassword(user.getPassword());
			}
			if (Objects.nonNull(user.getRole()) && !"".equalsIgnoreCase(user.getRole())) 
			{
				userDb.setRole(user.getRole());
			}
			
			return usrep.save(userDb);
		}
		else {
			throw new NotValidException("username or password not valid");
		}
	}
	public List<User> getAll()   //userdefined method to get all users
	{
	    List<User> list = new ArrayList<User>();
		usrep.findAll().forEach(list::add);//crud method //using method reference adding all elements to the list
		return list;
	}
	
	public User fetchById(int userId)  
	{
		// TODO Auto-generated method stub
		Optional<User> user = usrep.findById(userId);
	    if(!user.isPresent())
	    		{
	    			throw new InValidIdException("invalid id");
	    		}
	    
	    return user.get();
	
	}
	public List<User> getByRole(String role) //to get user by her name
	{
		List<User> list = new ArrayList<User>();
		usrep.findByRole(role).forEach(list::add);//crud method //using method reference adding all elements to the list
		return list;
		//User user = usrep.findByRole(role);
//	    if(user==null)
//	    		{
//	    			throw new InValidIdException("invalid id");
//	    		}
//	    else 
//	    {
//	    	return usrep.findByRole(role);
//			
//		}
		
		
	}
	


}
