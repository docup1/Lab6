package Commands;

import Objects.Print;
import static Data.MainCollection.data;
public class Show extends Command{
    private String out = "";
    public void run(String[] a){
        for (int i = 0; i < data.size(); i++){
            out += data.get(i).toString() + "\n";
        }
    new Print().out(out);
    }
}
