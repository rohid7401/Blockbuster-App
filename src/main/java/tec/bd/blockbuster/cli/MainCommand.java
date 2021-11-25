package tec.bd.blockbuster.cli;

import picocli.CommandLine;
import picocli.CommandLine.HelpCommand;
import tec.bd.blockbuster.cli.movie.*;
import tec.bd.blockbuster.cli.customer.*;
import tec.bd.blockbuster.cli.category.*;
import tec.bd.blockbuster.cli.loan.*;

@CommandLine.Command(
        name = "BlockbusterAPP",
        subcommands = {
                GetMoviesCommand.class,
                GetByTitleCommand.class,
                CreateMovieCommand.class,
                DeleteMovieCommand.class,
                UpdateMovieCommand.class,
                CreateCustomerCommand.class,
                GetCustomerCommand.class,
                UpdateCustomerCommand.class,
                DeleteCustomerCommand.class,
                CreateCategoryCommand.class,
                GetCategoryCommand.class,
                UpdateCategoryCommand.class,
                DeleteCategoryCommand.class,
                CreateLoanCommand.class,
                GetLoanCommand.class,
                UpdateLoanCommand.class,
                DeleteLoanCommand.class,
                HelpCommand.class },
        description = "Manage Movies, Customers, Categories and Loans")

public class MainCommand implements Runnable {

    @Override
    public void run() {

    }
}
