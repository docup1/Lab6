package Commands;

import Objects.Analyzer;
import Objects.Print;
import UI.Console;

import java.io.File;
import java.util.Scanner;
public class Execute_script extends Command{
    File defaultLocation;
    File location;
    Scanner scan;
    public void run(String [] arg){
        location = new File(arg[0]);
        defaultLocation = new File(System.getProperty("user.dir") + "\\" + arg[0]);
        try {
            try {
                scan = new Scanner(location);
            }catch (Exception e){
                scan = new Scanner(defaultLocation);
            }
            while (scan.hasNext()) {
                String theData = scan.nextLine();
                new CommandManager(new Analyzer(theData));
            }
            scan.close();
        } catch (Exception e) {
            new Print().outErr("Can`t open file");
        }
    }
}
