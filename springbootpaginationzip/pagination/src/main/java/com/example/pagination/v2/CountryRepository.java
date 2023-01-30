package com.example.pagination.v2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface CountryRepository extends PagingAndSortingRepository<Country, Long>,JpaRepository<Country, Long>{
	
	@Query("SELECT new com.example.pagination.v2.Country(c.id,c.name,c.population) FROM Country c WHERE name=:cname ")
	List<Country> FindbyData(@Param("cname") String cname);
	
}
