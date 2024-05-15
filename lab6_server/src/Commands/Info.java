package Commands;

import Data.MusicBand;
import Objects.Print;
import Data.MainCollection;
import java.util.Vector;
import static Data.MainCollection.data;

import static Data.MainCollection.data;


public class Info extends Command{
    private String out = "";
    public void run(String[] a){

        out +=  "" +
                "Class: " + data.getClass() + "\n" +
                "Size: " + data.size() + "\n" +
                "";
        new Print().out(out);
    }
}
