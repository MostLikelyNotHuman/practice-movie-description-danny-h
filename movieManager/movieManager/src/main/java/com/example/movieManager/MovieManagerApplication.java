package com.example.movieManager;

//import ch.qos.logback.core.net.server.Client;
import com.example.movieManager.classes.Movie;
import com.example.movieManager.controllers.MovieController;
import com.example.movieManager.repositories.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.apache.http.HttpException;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class MovieManagerApplication {

	public static void main(String[] args) throws HttpException, IOException {
		SpringApplication.run(MovieManagerApplication.class, args);

        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        while (true) {
            selection = 0;
            System.out.println("Please choose an option: \n" +
                    "1: Enter the title and rating of a movie. AI will generate the description. \n" +
                    "2: Retrieve list of all generated movies. \n" +
                    "3: Exit");
            selection = scanner.nextInt();
            scanner.nextLine();
            if (selection == 1) {
                System.out.println("Please enter the title of a movie");
                String movieTitle = scanner.nextLine();
                System.out.println("Please enter your rating of the movie, on a scale from 1 - 10");
                int movieRating = scanner.nextInt();
                scanner.nextLine();
//                String movieDescription = client.models.generateContent
//                        ("gemini-2.5-flash-lite", "Please create a summary of the movie " + movieTitle + " that is less than 500 characters.", null).toString();
                String movieDescription = "MOVIEDESCRIPTION" + movieTitle;
                MovieController movieController = new MovieController(null);
                Movie movie = new Movie(movieTitle, movieRating, movieDescription);
                movieController.createMovie(movie);
            } else if (selection == 2) {
                MovieController movieController = new MovieController(null);
                movieController.getAllMovies();
            } else if (selection == 3) {
                break;
            } else {
                System.out.println("Invalid selection.");
            }
        }



//        Client client = new Client();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a question for the model:");
//        String query = scanner.nextLine();
//
//        GenerateContentResponse response =
//                client.models.generateContent("gemini-2.5-flash-lite", query, null);
//
//        System.out.println(response.text());

    }






}
