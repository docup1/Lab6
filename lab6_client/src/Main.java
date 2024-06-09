import Commands.CommandManager;
import Data.MainCollection;
import Objects.Analyzer;
import Objects.Answer;
import Objects.Client;
import Objects.Print;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Client cl;
        CommandManager com;
        new MainCollection();
        while (true){
            System.out.printf(">>> ");
            input = new String(new Scanner(System.in).nextLine());
            com = new CommandManager(new Analyzer(input));
            cl = new Client();
            cl.send(com.returnCommand());
            Answer answer = cl.receive();
            System.out.println(answer.toString());
            cl.close();
        }
    }
}