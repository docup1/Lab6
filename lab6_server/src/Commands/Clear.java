package Commands;

import Objects.Print;

import static Data.MainCollection.data;
import static Data.MainCollection.notUsedID;

public class Clear extends Command{
    public void run(String [] a){
        try {
            for(int i = 0; i < data.size(); i++) data.remove(i);
            for(int i = 0; i < notUsedID.size(); i++) notUsedID.remove(i);
            new Print().out("Sucsesfuly cleared");
        }catch (Exception e){
            new Print().outErr("Field");
        }
    }
}
