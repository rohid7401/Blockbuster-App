package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "cusd", description = "Delete Customer")
public class DeleteCustomerCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<customer ced>", description = "Ced of customer")
    private long customerCed;


    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.removeCustomer(customerCed);

        System.out.println("Customer Ced: " + customerCed + " was deleted successfully");
    }
}
