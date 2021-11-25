package tec.bd.blockbuster.cli.movie;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.entity.Movie;

import java.util.Date;

@Command(name = "movc", description = "Create Movies")
public class CreateMovieCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<movie id>", description = "Id of movie")
    private long id;
    @CommandLine.Parameters(paramLabel = "<movie title>", description = "Title of movie")
    private String title;
    @CommandLine.Parameters(paramLabel = "<release date>", description = "Date of release")
    private Date releaseDate;
    @CommandLine.Parameters(paramLabel = "<category id>", description = "Id of category")
    private long category;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        var newMovie = new Movie(id, title, releaseDate, category);

        blockbuster.addMovie(newMovie);
    }
}