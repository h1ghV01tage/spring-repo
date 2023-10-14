package com.model;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("movie-service.xml");
		MovieService movieService =(MovieService)applicationContext.getBean("movieService");
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter movie name");
		String name = scanner.next();
		
		System.out.println("Enter director name");
		String director = scanner.next();
		
		
		//creating the data
		Movie movie = new Movie();
		movie.setName(name);
		movie.setDuration(122);
		movie.setRating(12);
		movie.setDirector(director);
		movie.setYear(2019);
		movieService.save(movie);
		
		System.out.println("Ahaha movie is saved");
		
		Movie movie2 = movieService.findById(12);
		System.out.println(movie2);
	}
	
}
