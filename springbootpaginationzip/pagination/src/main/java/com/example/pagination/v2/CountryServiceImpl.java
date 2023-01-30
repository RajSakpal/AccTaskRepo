package com.example.pagination.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
    private CountryRepository repository;

    @Override
    public List<Country> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Country> pagedResult = repository.findAll(paging);

        return pagedResult.toList();
    }
    @Override
    public List<Country> findSortedBy(int pageNo, int pageSize,String sortby) {

        Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortby).ascending());
        Page<Country> pagedResult = repository.findAll(paging);

        return pagedResult.toList();
    }
	@Override
	public List<Country> findSortedByName(String cname) {
		// TODO Auto-generated method stub
		return repository.FindbyData(cname);
	}
	
}
