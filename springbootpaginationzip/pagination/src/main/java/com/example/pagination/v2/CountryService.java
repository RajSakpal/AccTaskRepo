package com.example.pagination.v2;

import java.util.List;

public interface CountryService {
	List<Country> findPaginated(int pageNo, int pageSize);
	List<Country> findSortedBy(int pageNo, int pageSize,String sortby);
	List<Country> findSortedByName(String cname);
}
