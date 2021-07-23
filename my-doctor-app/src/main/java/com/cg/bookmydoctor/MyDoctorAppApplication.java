package com.cg.bookmydoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.bookmydoctor.dao.IUserRepository;
import com.cg.bookmydoctor.dto.User;

@SpringBootApplication
public class MyDoctorAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ct=SpringApplication.run(MyDoctorAppApplication.class, args);
		
		
//		  IUserRepository usr = ct.getBean(IUserRepository.class); 
//		  User user = new User();
//		   
//		  user.setUserName("saukarya");
//		  user.setPassword("mitrA98768");
//		  user.setRole("admin");  //admin, doctor or user
//		  usr.save(user);
		 
		
	}

}
