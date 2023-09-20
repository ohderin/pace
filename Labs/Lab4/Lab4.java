/*
 * Author: Derin Ergul
 * Date: 9/19/23
 * CSC1351 Lauren Pace
 * Description: this program reads movies from a file and sorts them by rating in descending order
 */

import java.io.*;
import java.util.*;

class Movie implements Comparable<Movie> {
    private String title;
    private String director;
    private int year;
    private double rating;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public int compareTo(Movie other) {
        // Compare movies by rating in descending order
        return Double.compare(this.rating, other.rating);
    }

    public String toString() {
        return title + ", Directed by " + director + ", Came out in: " + year + ", Has a rating of " + rating;
    }
}

public class Lab4 {
    public static void main(String[] args) {
        List<Movie> moviesList = new ArrayList<>();

        // Read data from input.txt and create Movie objects
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String title = parts[0];
                    String director = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    double rating = Double.parseDouble(parts[3]);
                    moviesList.add(new Movie(title, director, year, rating));
                }
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }

        // Sort movies by rating in descending order
        Collections.sort(moviesList, Collections.reverseOrder());

        // Write sorted movie data to output.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println("My Movie Library");
            writer.println("*******************************************************************");
            for (Movie movie : moviesList) {
                writer.println(movie.toString());
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
