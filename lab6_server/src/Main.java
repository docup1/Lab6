import Objects.Parser;
import Objects.Print;
import UI.Server;
import UI.Console;

public class Main {
    public static void main(String[] args) {
        new Parser().init();
        Console thr1 = new Console();
        Server thr2 = new Server();
        thr1.start();
        thr2.start();
    }
}