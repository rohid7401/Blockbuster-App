package tec.bd.blockbuster.cli.loan;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "loand", description = "Delete Loan")
public class DeleteLoanCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<loan ced>", description = "Ced of loan")
    private long loanCed;
    @CommandLine.Parameters(paramLabel = "<loan cod>", description = "Cod of loan")
    private long loanCod;


    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.removeLoan(loanCed, loanCod);

        System.out.println("Loan Ced: " + loanCed + " Cod: " + loanCod + " was deleted successfully");
    }
}
