package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.LoginServiceImpl.LoginServiceImpl;
import com.demo.model.login;


@RestController  
public class LoginController {
	@Autowired
	LoginServiceImpl loginService;
	
	@GetMapping("/login")  
	private List<login> getAllBooks()   
	{  
	return loginService.getAlllogin();  
	}  
	
	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/login/{loginid}")  
	private login getlogin(@PathVariable("loginid") int loginid)   
	{  
	return loginService.getloginById(loginid);  
	}  
	
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/login/{loginid}")  
	private String deleteBook(@PathVariable("loginid") int loginid)   
	{  
	loginService.delete(loginid);  
	return "record deleted";
	}  
	
	//creating post mapping that post the book detail in the database  
	@PostMapping("/login")  
	private String savelogin(@RequestBody login login)   
	{  
	loginService.saveOrUpdate(login);  
	return "record inserted";  
	}  
	
	//creating put mapping that updates the book detail   
	@PutMapping("/login")  
	private login update(@RequestBody login login)   
	{  
	loginService.saveOrUpdate(login);  
	return login;  
	}  
}
