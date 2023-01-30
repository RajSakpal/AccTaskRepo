package com.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.model.login;

public interface LoginRepository extends JpaRepository<login, Integer>{

}
