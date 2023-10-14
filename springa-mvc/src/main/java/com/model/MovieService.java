package com.model;

import java.util.List;

public interface MovieService {

	void save(Movie movie);

	Movie findById(int mid);

	List<Movie> findAll();

	int findCount();

	void deleteById(int mid);

}
