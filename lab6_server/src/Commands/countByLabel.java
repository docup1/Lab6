package Commands;

import Data.Label;
import Objects.Print;
import static Data.MainCollection.data;
public class countByLabel extends Command{
    Label lab = new Label();
    int n;
    public void run(String[] arg) {
        lab.Seter(Long.parseLong(arg[0]));
        n = 0;
        for(int i = 0; i < data.size();i++){
            if(data.get(i).GetLabel().GetSale() >= lab.GetSale()){
                n++;
            }
        }
        new Print().out("Matching items found: " + n );
    }
}
