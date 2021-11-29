package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.entity.Customer;

@Command(name = "cusc", description = "Create Customer")
public class CreateCustomerCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<customer ced>", description = "Ced of customer")
    private long ced;
    @CommandLine.Parameters(paramLabel = "<customer name>", description = "Name of customer")
    private String name;
    @CommandLine.Parameters(paramLabel = "<customer lastname>", description = "Lastname of customer")
    private String lastname;
    @CommandLine.Parameters(paramLabel = "<customer address>", description = "Address of customer")
    private String address;
    @CommandLine.Parameters(paramLabel = "<customer number>", description = "Number of customer")
    private String number;

    @Override
    public void run(){
        var blockbuster = new ApplicationContext().getBlockbuster();

        var newCustomer = new Customer(ced, name, lastname, address, number);

        blockbuster.addCustomer(newCustomer);
    }
}
