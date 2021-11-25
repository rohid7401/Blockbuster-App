package tec.bd.blockbuster.cli.movie;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Movie;

import java.util.List;

@Command(name = "movr", description = "Get All Movies")
public class GetMoviesCommand implements Runnable {

    @Parameters(paramLabel = "<movie id>", description = "Id of movie", defaultValue = "0")
    private long movieId;

    @Override
    public void run() {

        System.out.println("movieId: " + movieId);
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();

        if (movieId != 0) {
            // La logica encontrar por movieId
            System.out.println("=== Get Movie Id === ");
            var movie = blockbuster.getMovie(movieId);

            System.out.println("Title: "+ movie.getTitle() + ", Id: " + movie.getMovieId());

        } else {

            System.out.println("=== Get All Movies === ");

            List<Movie> movies = blockbuster.getAllMovies();

            System.out.println("Codigo \t\t Titulo");
            for (Movie m : movies) {
                System.out.println(m.getMovieId() + "\t\t" + m.getTitle());
            }

        }
    }

}