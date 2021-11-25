package tec.bd.blockbuster.cli.movie;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "movt", description = "Search Movies by Title")
public class GetByTitleCommand implements Runnable {

    @Parameters(paramLabel = "<movie title>", description = "Title of movie")
    private String title;

    @Override
    public void run() {

        var blockbuster = new ApplicationContext().getBlockbuster();
        var movie = blockbuster.getMovie(title);

        System.out.println("Id " + movie.getMovieId() + ", Titulo " + movie.getTitle());

    }
}