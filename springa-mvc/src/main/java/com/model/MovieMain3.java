package com.model;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieMain3 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("movie-service.xml");
		MovieService movieService =(MovieService)applicationContext.getBean("movieService");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter movie id");
		int mid = scanner.nextInt();
		Movie movie = movieService.findById(mid);
		System.out.println(movie);
		
	
	}
	
}
