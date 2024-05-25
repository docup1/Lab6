package Commands;

import Objects.Print;
import static Data.MainCollection.data;
import static Data.MainCollection.notUsedID;

public class Remove extends Command{
    public void run(){
        try{
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).GetID() == Integer.parseInt(argument[0])){
                    data.remove(i);
                    notUsedID.add(Integer.parseInt(argument[0]));
                    break;
                }
            }

            new Print().out("Sucsesfuly removed");
        }catch (Exception e){
            new Print().outErr("Field");
        }
    }
}
