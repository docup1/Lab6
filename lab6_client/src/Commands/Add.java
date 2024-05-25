package Commands;

import Data.MusicBand;
import Objects.Print;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static Data.MainCollection.data;
import static Data.MainCollection.notUsedID;
public class Add extends Command{
    private MusicBand val;
    String out;
    private int id;
    public void run(){
        try{

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            if(notUsedID.size() > 0){
                try {
                    id = notUsedID.get(0);
                    notUsedID.remove(0);
                }catch (Exception e){}
            }
            else id = data.size() + 1;
            val = new MusicBand(
                    id,
                    argument[0],
                    argument[1], Integer.parseInt(argument[2]),
                    dateFormat.format(date),
                    Integer.parseInt(argument[3]),
                    argument[4],
                    argument[5],
                    argument[6]
            );
            data.add(val);
            new Print().out("Sucsesfuly added");
        }catch (Exception e){
             out = "Illegal input.\n" +
                    "Command should look like:\n" +
                    "add [Name] [Cord: x] [Cord: y] [numberOfParticipants] [albumsCount] [Genre:( 'MATH_ROCK', 'PUNK_ROCK', 'BRIT_POP' )] [Label: sales]";
            new Print().outErr(out);
        }
    }
}
