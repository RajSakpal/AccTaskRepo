package com.demo.LoginServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.login;
import com.demo.respository.LoginRepository;
import com.demo.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired  
	LoginRepository loginRepository;
	
		@Override
		public List<login> getAlllogin()   
		{  
		List<login> login = new ArrayList<login>();  
		loginRepository.findAll().forEach(login1 -> login.add(login1));  
		return login;  
		}  
		//getting a specific record by using the method findById() of CrudRepository  
		@Override
		public login getloginById(int id)   
		{  
		return loginRepository.findById(id).get();  
		}  
		//saving a specific record by using the method save() of CrudRepository'
		@Override
		public void saveOrUpdate(login login)   
		{  
		loginRepository.save(login);  
		}  
		//deleting a specific record by using the method deleteById() of CrudRepository
		@Override
		public void delete(int id)   
		{  
		loginRepository.deleteById(id);  
		}  
		//updating a record  
		@Override
		public void update(login login, int id)   
		{  
		loginRepository.save(login);  
		}  
}
