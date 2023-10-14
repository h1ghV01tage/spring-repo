package com.model;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieMain2 {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("movie-service.xml");
		MovieService movieService =(MovieService)applicationContext.getBean("movieService");
		List<Movie> movies = movieService.findAll();
		movies.forEach(System.out::println);
		
	
	}
	
}
