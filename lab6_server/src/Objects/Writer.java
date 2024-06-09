package Objects;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import static Data.MainCollection.*;
public class Writer {
    private String fileName = "colection.xml";
    private String infoFile = "info.xml";
    private String out = "";
    private String historyOut = "";
    private String idOut = "";
    private int id;
    private String name;
    private Long X;
    private int Y;
    private String date;
    private int Num;
    private long alb;
    private String genre;
    private Long sales;
    private String location = System.getenv("MUSICBAND") + "\\" + fileName;
    private String infoFileLocation = System.getenv("MUSICBAND") + "\\" + infoFile;
    private String ELEMENT;
    public void init(){
        out = "";
        idOut = "";
        historyOut = "";
        for (int i = 0; i < data.size(); i++) {
            this.id = data.get(i).GetID();
            this.name = data.get(i).GetName();
            this.X = data.get(i).GetCord().GetX();
            this.Y = data.get(i).GetCord().GetY();
            this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(data.get(i).GetDate());
            this.Num = data.get(i).GetNum();
            this.alb = data.get(i).GetAlbum();
            this.genre = data.get(i).GetGenre().Geter();
            this.sales = data.get(i).GetLabel().GetSale();
            ELEMENT = "\t<ELEMENT>\n" +
                    "\t\t<id>" + id + "</id>\n" +
                    "\t\t<name>"+ name +"</name>\n" +
                    "\t\t<coordinates>\n" +
                    "\t\t\t<X>" + X + "</X>\n" +
                    "\t\t\t<Y>" + Y + "</Y>\n" +
                    "\t\t</coordinates>\n" +
                    "\t\t<creationDate>" + date + "</creationDate>\n" +
                    "\t\t<numberOfParticipants>" + Num + "</numberOfParticipants>\n" +
                    "\t\t<albumsCount>" + alb + "</albumsCount>\n" +
                    "\t\t<genre>" + genre + "</genre>\n" +
                    "\t\t<label>\n" +
                    "\t\t\t<sales>" + sales + "</sales>\n" +
                    "\t\t</label>\n" +
                    "\t</ELEMENT>\n";
            out += ELEMENT;
        }
        for (int i = 0; i < notUsedID.size(); i++) {
            ELEMENT = "\t<element>" + notUsedID.get(i) + "</element>\n";
            idOut += ELEMENT;
        }
        for (int i = 0; i < history.size(); i++) {
            ELEMENT = "\t<command>" + history.get(i) + "</command>\n";
            historyOut += ELEMENT;
        }
        this.save();
    }
    public void save(){
        try{
            PrintWriter pw1 = new PrintWriter(new FileWriter(location));
            pw1.printf("<MusicBand>\n");
            pw1.printf(out);
            pw1.printf("</MusicBand>");
            pw1.close();
        }catch (Exception e){}
        try {
            PrintWriter pw2 = new PrintWriter(new FileWriter(infoFileLocation));
            pw2.printf("<history>\n");
            pw2.printf(historyOut);
            pw2.printf("</history>\n");
            pw2.printf("<notUsedID>\n");
            pw2.printf(idOut);
            pw2.printf("</notUsedID>");
            pw2.close();
        }catch (Exception e){}
    }
}
