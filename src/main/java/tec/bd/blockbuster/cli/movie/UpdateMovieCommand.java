package tec.bd.blockbuster.cli.movie;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "movu", description = "Update Movie")
public class UpdateMovieCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<movie name>", description = "Name of movie")
    private String name;
    @CommandLine.Parameters(paramLabel = "<movie name>", description = "New name of movie")
    private String newName;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.editMovieTitle(name, newName);
    }

}