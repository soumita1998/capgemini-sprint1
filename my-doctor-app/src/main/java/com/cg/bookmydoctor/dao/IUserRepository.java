package com.cg.bookmydoctor.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmydoctor.dto.User;
@Repository("reposi")
public interface IUserRepository extends CrudRepository<User,Integer> 
{
	public List<User> findByRole(String role);
	
}
