package Commands;

import Objects.Print;

import static Data.MainCollection.history;
public class History extends Command{
    String strHist = "";
    public void run(String [] arg){
        for(int i = 0; i < history.size(); i++){
            strHist+= history.get(i) + "\n";
        }
        new Print().out(strHist);
    }
}
