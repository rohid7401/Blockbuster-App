package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "cusu", description = "Update Customer")
public class UpdateCustomerCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<customer ced>", description = "Ced of customer")
    private long ced;
    @CommandLine.Parameters(paramLabel = "<customer address>", description = "Address of customer")
    private String address;
    @CommandLine.Parameters(paramLabel = "<customer number>", description = "Number of customer")
    private String number;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.editCustomer(ced, address, number);
    }

}