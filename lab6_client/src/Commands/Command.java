package Commands;

import java.io.Serializable;

public abstract class Command implements Serializable {
    String[] argument;
    public void init(String[] argument){
        this.argument = argument;
    };
    public abstract void run();
}
