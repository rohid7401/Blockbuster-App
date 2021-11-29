package tec.bd.blockbuster;

import picocli.CommandLine;
import tec.bd.blockbuster.cli.MainCommand;

public class Main {

    public static void main(String... args) {

        CommandLine cmd = new CommandLine(new MainCommand());
        cmd.setExecutionStrategy(new CommandLine.RunAll());
        cmd.execute(args);

        if (args.length == 0) { cmd.usage(System.out); }

        System.out.println("Blockbuster");

    }
}
