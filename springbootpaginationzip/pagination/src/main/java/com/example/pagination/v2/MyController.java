package com.example.pagination.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	 @Autowired
	    private CountryServiceImpl countryService;

	    @GetMapping("/countries/{pageNo}/{pageSize}")
	    public List<Country> getPaginatedCountries(@PathVariable int pageNo, 
	            @PathVariable int pageSize) {

	        return countryService.findPaginated(pageNo, pageSize);
	    }
	    
	    @GetMapping("/countries/{pageNo}/{pageSize}/{sortby}")
	    public List<Country> getSortedBy(@PathVariable int pageNo, 
	            @PathVariable int pageSize,@PathVariable String sortby) {

	        return countryService.findSortedBy(pageNo, pageSize,sortby);
	    }
	    
	    @GetMapping("/countries/{countryname}")
	    public List<Country> getSortedBy(@PathVariable String cname) {

	        return countryService.findSortedByName(cname);
	    }
	
}
