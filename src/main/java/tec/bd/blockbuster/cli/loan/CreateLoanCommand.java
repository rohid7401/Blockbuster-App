package tec.bd.blockbuster.cli.loan;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.entity.Loan;

import java.util.Date;

@Command(name = "loanc", description = "Create Loan")
public class CreateLoanCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<customer ced>", description = "Ced of customer")
    private long ced;
    @CommandLine.Parameters(paramLabel = "<customer name>", description = "Name of customer")
    private long cod;
    @CommandLine.Parameters(paramLabel = "<customer lastname>", description = "Lastname of customer")
    private String state;
    @CommandLine.Parameters(paramLabel = "<customer address>", description = "Address of customer")
    private Date loanDate;
    @CommandLine.Parameters(paramLabel = "<customer number>", description = "Number of customer")
    private Date returnDate;

    @Override
    public void run(){
        var blockbuster = new ApplicationContext().getBlockbuster();

        var newLoan = new Loan(ced, cod, state, loanDate, returnDate);

        blockbuster.addLoan(newLoan);
    }
}
