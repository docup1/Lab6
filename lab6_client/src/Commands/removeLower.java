package Commands;

import Objects.Print;

import static Data.MainCollection.data;
import static Data.MainCollection.notUsedID;
public class removeLower extends Command{
    private void remove(int id){
        for (int i = 0; i < data.size(); i++){
            if(data.get(i).GetID() == id){
                data.remove(i);
                notUsedID.add(id);
                break;
            }
        }
    }
    public void run() {
        try{
            for (int i = 0; i < Integer.parseInt(argument[0]); i++) remove(i);
            new Print().out("Sucsesfuly removed");
        }catch (Exception e){new Print().outErr("Field");}
    }
}
