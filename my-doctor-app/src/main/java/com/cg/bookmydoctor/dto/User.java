package com.cg.bookmydoctor.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="Usertable")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	@NotBlank
	private String role;
	public User( String userName, String password, String role) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

}
