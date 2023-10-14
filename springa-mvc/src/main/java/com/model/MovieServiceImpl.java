package com.model;
import java.sql.Timestamp;
import java.util.Date;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MovieServiceImpl implements MovieService {

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Movie movie) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into movies_tbl(name,director,rating,duration,year,doe) values(?,?,?,?,?,?)";
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Object [] data = {movie.getName(), movie.getDirector(),movie.getRating(),movie.getDuration(),movie.getYear(),timestamp};
		
		jdbcTemplate.update(sql,data);
	}
	
	@Override
	public Movie findById(int mid) {
		
		Movie movie = new Movie();
		movie.setMid(mid);
		movie.setDirector("Albert");
		movie.setDuration(123);
		movie.setName("Hero");
		movie.setRating(10);
		return movie;
		
	}
	
}
