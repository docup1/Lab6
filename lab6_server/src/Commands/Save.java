package Commands;

import Objects.Print;
import Objects.Writer;
public class Save extends Command{
    public void run(){
        try{
            new Writer().init();
            new Print().out("Sucsesfuly saved");
        }catch (Exception e){
            new Print().outErr("Field");
        }
    }
}
