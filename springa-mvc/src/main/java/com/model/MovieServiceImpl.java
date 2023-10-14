package com.model;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MovieServiceImpl implements MovieService {

	private JdbcTemplate jdbcTemplate;
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Movie movie) {
		
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into movies_tbl(name,director,rating,duration,year,doe) values(?,?,?,?,?,?)";
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Object [] data = {movie.getName(), movie.getDirector(),movie.getRating(),movie.getDuration(),movie.getYear(),timestamp};
		
		//fire the query
		jdbcTemplate.update(sql,data);
	}
	

	@Override
	public Movie findById(int mid) {
		
		String sql = "select mid,name,director,rating,duration,year,doe from movies_tbl where mid=?";
		Object [] data = {mid};
		Movie movie = jdbcTemplate.queryForObject(sql, data,new BeanPropertyRowMapper<>(Movie.class));
		return movie;
		
	}
	
	@Override
	public List<Movie> findAll() {
		
		String sql = "select mid,name,director,rating,duration,year,doe from movies_tbl";
		List<Movie> movies = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class));
		return movies;
		
	}
	
	@Override
	public int findCount() {
		
		String sql = "select mid,name,director,rating,duration,year,doe from movies_tbl";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
		
	}
	
	@Override
	public void deleteById(int mid) {
		
		String sql = "delete from movies_tbl where mid=?";
		Object [] data = {mid};
		int rows = jdbcTemplate.update(sql, data);
		System.out.println("number of rows is deleted " + rows);
	
		
	}
	
	
	
}
