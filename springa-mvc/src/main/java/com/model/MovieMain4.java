package com.model;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieMain4 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("movie-service.xml");
		MovieService movieService =(MovieService)applicationContext.getBean("movieService");
		Scanner scanner = new Scanner(System.in);
		System.out.println("delete which movie, id ?");
		int mid = scanner.nextInt();
		movieService.deleteById(mid);
		System.out.println("deleted movie " + mid);
		
		//show the remaining data
		List<Movie> movies = movieService.findAll();
		movies.forEach(System.out::println);
	
	}
	
}
