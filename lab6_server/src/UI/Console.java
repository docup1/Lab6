package UI;

import Commands.CommandManager;
import Objects.Analyzer;
import static Objects.Print.out;
import java.util.Scanner;

public class Console extends Thread{

    public void run(){
        String input;
        while (true){
            input = new String(new Scanner(System.in).nextLine());
            new CommandManager(new Analyzer(input));
            System.out.printf(out);
        }
    }

}
