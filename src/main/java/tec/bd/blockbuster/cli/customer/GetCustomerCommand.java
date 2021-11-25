package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Customer;

import java.util.List;

@Command(name = "cusr", description = "Get All Customers")
public class GetCustomerCommand implements Runnable {

    @Parameters(paramLabel = "<customer id>", description = "Id of customer", defaultValue = "0")
    private long customerId;

    @Override
    public void run() {

        System.out.println("customerId: " + customerId);
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();

        if (customerId != 0) {
            // La logica encontrar por customerId
            System.out.println("=== Get Customer Id === ");
            var customer = blockbuster.getCustomer(customerId);

            System.out.println("Name: "+ customer.getName() + ", Ced: " + customer.getCustomer());

        } else {

            System.out.println("=== Get All Customers === ");

            List<Customer> customers = blockbuster.getAllCustomers();

            System.out.println("Codigo \t\t Titulo");
            for (Customer c : customers) {
                System.out.println(c.getCustomer() + "\t\t" + c.getName());
            }

        }
    }

}