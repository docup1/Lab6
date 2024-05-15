import Objects.Client;
import Objects.Print;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Print().printMass();
        String input;
        Client cl;
        while (true){
            input = new String(new Scanner(System.in).nextLine());
            cl = new Client();
            System.out.println(cl.send(input));
            cl.close();
        }
    }
}