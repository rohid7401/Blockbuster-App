package tec.bd.blockbuster.cli.category;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.entity.Category;

@Command(name = "catc", description = "Create Category")
public class CreateCategoryCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<category id>", description = "Id of category")
    private long id;
    @CommandLine.Parameters(paramLabel = "<category name>", description = "Name of category")
    private String name;

    @Override
    public void run(){
        var blockbuster = new ApplicationContext().getBlockbuster();

        var newCategory = new Category(id, name);

        blockbuster.addCategory(newCategory);
    }
}
