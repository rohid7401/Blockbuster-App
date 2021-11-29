package tec.bd.blockbuster.cli.loan;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

import java.util.Date;

@Command(name = "loanu", description = "Update Loan")
public class UpdateLoanCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<loan id>", description = "Ced of loan")
    private long ced;
    @CommandLine.Parameters(paramLabel = "<loan name>", description = "Cod of loan")
    private long cod;
    @CommandLine.Parameters(paramLabel = "<loan id>", description = "Ced of loan")
    private String estado;
    @CommandLine.Parameters(paramLabel = "<loan name>", description = "Cod of loan")
    private Date fecha_devolucion;


    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.editLoan(ced, cod, estado, fecha_devolucion);
    }

}