package Objects;

import Data.MusicBand;
import static Data.MainCollection.data;
import static Data.MainCollection.notUsedID;
import static Data.MainCollection.history;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Parser {
    public static final Pattern ElementPattern = Pattern.compile("" +
            "<ELEMENT>" +
                "\\t*\\n*\\s*<id>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/id>" +
                "\\t*\\n*\\s*<name>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/name>" +
                "\\t*\\n*\\s*<coordinates>" +
                    "\\t*\\n*\\s*<X>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/X>" +
                    "\\t*\\n*\\s*<Y>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/Y>" +
                "\\t*\\n*\\s*<\\/coordinates>" +
                "\\t*\\n*\\s*<creationDate>\\t*\\n*\\s*(\\w+/\\w+/\\w+\\s\\w+\\:\\w+\\:\\w+)\\t*\\n*\\s*<\\/creationDate>" +
                "\\t*\\n*\\s*<numberOfParticipants>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/numberOfParticipants>" +
                "\\t*\\n*\\s*<albumsCount>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/albumsCount>" +
                "\\t*\\n*\\s*<genre>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/genre>" +
                "\\t*\\n*\\s*<label>" +
                    "\\t*\\n*\\s*<sales>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/sales>" +
                "\\t*\\n*\\s*<\\/label>" +
            "\\t*\\n*\\s*<\\/ELEMENT>",
            Pattern.CASE_INSENSITIVE);
    public static final Pattern HistoryPattern = Pattern.compile("" +
                    "\\t*\\n*\\s*<command>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/command>",
                    Pattern.CASE_INSENSITIVE);
    public static final Pattern NotUsedIdPattern = Pattern.compile("" +
                    "\\t*\\n*\\s*<element>\\t*\\n*\\s*(\\w+)\\t*\\n*\\s*<\\/element>",
                    Pattern.CASE_INSENSITIVE);
    String fileName = "colection.xml";
    String infoFile = "info.xml";
    File location;
    File infoLocation;
    String XMLstring = new String();
    String XMLinfoString = new String();
    public void init() {
        try {
            location = new File(System.getenv("MUSICBAND") + "\\" + fileName);

            try {
                Scanner scan = new Scanner(location);
                while (scan.hasNext()) {
                    String theData = scan.nextLine();
                    XMLstring += (theData);
                }
                scan.close();
            } catch (Exception e) {
            }
            Matcher matcher = ElementPattern.matcher(XMLstring);
            while (matcher.find()) {

                data.add(
                        new MusicBand(
                                Integer.parseInt(matcher.group(1)),
                                matcher.group(2),
                                matcher.group(3),
                                Integer.parseInt(matcher.group(4)),
                                matcher.group(5),
                                Integer.parseInt(matcher.group(6)),
                                matcher.group(7),
                                matcher.group(8),
                                matcher.group(9)
                        )
                );
            }
            infoLocation = new File(System.getenv("MUSICBAND") + "\\" + infoFile);
            try {
                Scanner scan = new Scanner(infoLocation);
                while (scan.hasNext()) {
                    String theData = scan.nextLine();
                    XMLinfoString += (theData);
                }
                scan.close();
            } catch (Exception e) {
            }
            Matcher matcher1 = NotUsedIdPattern.matcher(XMLinfoString);
            Matcher matcher2 = HistoryPattern.matcher(XMLinfoString);
            while (matcher1.find()) {
                notUsedID.add(Integer.parseInt(matcher1.group(1)));
            }
            while (matcher2.find()) {
                history.add(matcher2.group(1));
            }
        }catch (Exception e){
            new Writer().save();
        }
    }
}
