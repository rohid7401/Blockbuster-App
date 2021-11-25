package tec.bd.blockbuster.cli.loan;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Loan;

import java.util.List;

@Command(name = "loanr", description = "Get All Loansse ")
public class GetLoanCommand implements Runnable {

    @Parameters(paramLabel = "<loan ced>", description = "Ced of loan", defaultValue = "0")
    private long loanCed;
    @Parameters(paramLabel = "<loan cod>", description = "Cod of loan", defaultValue = "0")
    private long loanCod;

    @Override
    public void run() {

        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();

        if ((loanCed != 0 && loanCod!= 0)) {
            // La logica encontrar por categoryId
            System.out.println("=== Get Category Id === ");
            var loan = blockbuster.getLoan(loanCed, loanCod);

            System.out.println("Ced: "+ loan.getCedula() + ", Cod: " + loan.getCodigo() + ", Estado: " + loan.getEstado());

        } else {

            System.out.println("=== Get All Loans === ");

            List<Loan> loans = blockbuster.getAllLoan();

            System.out.println("Cedula-Codigo \t\t Estado");
            for (Loan c : loans) {
                System.out.println(c.getCedula() + "-" + c.getCodigo() + "\t\t" + c.getEstado());
            }
        }
    }
}
