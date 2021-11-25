package tec.bd.blockbuster.cli.category;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "catd", description = "Delete Category")
public class DeleteCategoryCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<category id>", description = "Id of category")
    private long categoryId;


    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.removeCategory(categoryId);

        System.out.println("Category Id: " + categoryId + " was deleted successfully");
    }
}
