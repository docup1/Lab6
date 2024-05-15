package Objects;

public class Print {
    String helpInfo = "help - выводит список всех доступных команд";
    String errMasage = "Illegal argument";
    public void out(int out){
        System.out.printf(
                out + "\n"
        );
    }
    public void out(String out){
        System.out.printf(
                out + "\n"
        );
    }
    public void outErr(String s) {
        System.err.printf( s + "\n");
    }
    public void printErr(){
        System.err.printf(errMasage + "\n");
    }
    public void printMass(){
        System.out.printf(helpInfo + "\n");
    }
}
