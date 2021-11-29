package tec.bd.blockbuster.cli.category;

import picocli.CommandLine.Command;
import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "catu", description = "Update Category")
public class UpdateCategoryCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<category id>", description = "Id of category")
    private long id;
    @CommandLine.Parameters(paramLabel = "<category name>", description = "Name of category")
    private String name;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.editCategory(id, name);
    }

}