package Commands;

import Data.MusicBand;
import Objects.Print;

import java.util.Collections;
import java.util.Vector;

import static Data.MainCollection.data;

public class printFieldAscendingLabel extends Command{
    String out = "";
    boolean needIteration = true;
    private Vector<MusicBand> vec = new Vector<>();

    public void run(String arg[]){
        for(int i = 0; i < data.size(); i++){
            vec.add(i, data.get(i));
        }
        try {
            while (needIteration) {
                needIteration = false;
                for (int i = 1; i < vec.size(); i++) {
                    if (vec.get(i).GetLabel().GetSale() < vec.get(i - 1).GetLabel().GetSale()) {
                        Collections.swap(vec, i, i-1);
                        needIteration = true;
                    }
                }
            }
            for (int i = 0; i < vec.size(); i++){
                out += vec.get(i).toString() + "\n";
            }
            new Print().out(out);
        }catch (Exception e){}
    }
}
