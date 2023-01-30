package com.demo.service;

import java.util.List;

import com.demo.model.login;

public interface LoginService {
	List<login> getAlllogin();
	login getloginById(int id);
	void saveOrUpdate(login login);
	void delete(int id);
	void update(login login, int id);
}
