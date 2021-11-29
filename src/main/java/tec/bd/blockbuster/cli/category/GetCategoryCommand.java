package tec.bd.blockbuster.cli.category;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Category;

import java.util.List;

@Command(name = "catr", description = "Get All Categories")
public class

GetCategoryCommand implements Runnable {

    @Parameters(paramLabel = "<category id>", description = "Id of category", defaultValue = "0")
    private long categoryId;

    @Override
    public void run() {

        System.out.println("categoryId: " + categoryId);
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();

        if (categoryId != 0) {
            // La logica encontrar por categoryId
            System.out.println("=== Get Category Id === ");
            var category = blockbuster.getCategory(categoryId);

            System.out.println("Name: "+ category.getNombre() + ", Id: " + category.getId());

        } else {

            System.out.println("=== Get All Categories === ");

            List<Category> categories = blockbuster.getAllCategories();

            System.out.println("Codigo \t\t Titulo");
            for (Category c : categories) {
                System.out.println(c.getId() + "\t\t" + c.getNombre());
            }

        }
    }

}
