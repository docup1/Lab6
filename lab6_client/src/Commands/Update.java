package Commands;

import Objects.Print;
import static Data.MainCollection.data;
public class Update extends Command{
    private int pos;
    public void run(){
        try{
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).GetID() == Integer.parseInt(argument[0])){
                    pos = i;
                    break;
                }
            }
            data.get(pos).setName(argument[1]);
            data.get(pos).setCord(Long.parseLong(argument[2]), Integer.parseInt(argument[3]));
            data.get(pos).setNum(Integer.parseInt(argument[4]));
            data.get(pos).setAlbum(argument[5]);
            data.get(pos).setGenre(argument[6]);
            data.get(pos).setLabel(argument[7]);
            new Print().out("Sucsesfuly updated");
        }catch (Exception e){
            String out = "Illegal input.\n" +
                    "Command should look like:\n" +
                    "update [id] [Name] [Cord: x] [Cord: y] [numberOfParticipants] [albumsCount] [Genre:( 'MATH_ROCK', 'PUNK_ROCK', 'BRIT_POP' )] [Label: sales]";
            new Print().outErr(out);
        }
    }
}
