package Objects;

public class Print {
    public static String out;
    String errMasage = "Illegal argument";

    public void out(String out){
        this.out = out;
        this.out+="\n";
    }
    public void outErr(String s) {
        this.out = s;
        this.out+="\n";
    }
    public void printErr(){
        out = errMasage;
        out+="\n";
    }
    public void print(){
        System.out.printf(out);
    }
}
