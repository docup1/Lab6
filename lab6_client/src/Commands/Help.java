package Commands;

import Objects.Print;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import static Data.MainCollection.info;
public class Help extends Command {
    String out = "";


    public void run(){
        try{
            if(info.get(argument[0]) != null){
                new Print().out(info.get(argument[0]));
            }
            else{
                new Print().outErr("Command not found");
            }
        }catch(Exception e) {
            for (Map.Entry<String,String> f : info.entrySet()){
                out+=f.getValue();
                out+="\n";
            }

            new Print().out(out);
        }
    }
}
