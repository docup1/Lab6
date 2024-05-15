package Commands;

import Objects.Print;
import java.util.Collections;
import static Data.MainCollection.data;
public class Sort extends Command{
    private boolean needIteration = true;
    public void run(String arg[]){
        try {
            while (needIteration) {
                needIteration = false;
                for (int i = 1; i < data.size(); i++) {
                    if (data.get(i).GetID() < data.get(i - 1).GetID()) {
                        Collections.swap(data, i, i-1);
                        needIteration = true;
                    }
                }
            }
            new Print().out("Successfully sorted");
        }catch (Exception e){}
    }
}
