package Commands;

import Objects.Analyzer;
import Objects.Print;

import java.util.LinkedHashMap;

import static Data.MainCollection.history;

public class CommandManager {
    String print_out;
    public final LinkedHashMap<String, Command> commandsName;
    {
        commandsName = new LinkedHashMap<>();
        commandsName.put("help", new Help());
        commandsName.put("info", new Info());
        commandsName.put("add", new Add());
        commandsName.put("save", new Save());
        commandsName.put("show", new Show());
        commandsName.put("exit", new Exit());
        commandsName.put("update", new Update());
        commandsName.put("remove", new Remove());
        commandsName.put("clear", new Clear());
        commandsName.put("script", new Execute_script());
        commandsName.put("history", new History());
        commandsName.put("sort", new Sort());
        commandsName.put("print_label", new printFieldAscendingLabel());
        commandsName.put("remove_lower", new removeLower());
        commandsName.put("remove_by_label", new removeByLabel());
        commandsName.put("count_by_label", new countByLabel());
    }
    public CommandManager(Analyzer command) {
        try{
            Command com = commandsName.get(command.getTask());
            com.run(command.getArgument());
            if(command.getTask() != "history") {
                history.add(command.getTask());
                if(history.size() > 7) history.removeFirst();
            }
        }catch (Exception e){
            new Print().printErr();
        }
    }
}
