import Data.MainCollection;
import Objects.Parser;
import Objects.Server;

public class Main {
    public static void main(String[] args) {
        new Parser().init();
        new MainCollection();
        Server thr = new Server();
        thr.start();
    }
}