package Data;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;


public class MainCollection {
    public static Vector<MusicBand> data = new Vector<>();
    public static LinkedList<String> history = new LinkedList<>();
    public static Vector<Integer> notUsedID = new Vector<>();
    private Set<String> keys;
    private Collection<String> values;
    private Set<Map.Entry<String,String>> pairs;
    public static LinkedHashMap<String, String> info;
    public MainCollection() {
        info = new LinkedHashMap<>();
        info.put("info", "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        info.put("show","show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        info.put("add", "add {element} : добавить новый элемент в коллекцию");
        info.put("update", "update {element} : обновить значение элемента коллекции, id которого равен заданному");
        info.put("remove", "remove id : удалить элемент из коллекции по его id");
        info.put("clear", "clear : очистить коллекцию");
        info.put("save", "save : сохранить коллекцию в файл");
        info.put("script", "script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        info.put("remove_lower", "remove_lower id : удалить из коллекции все элементы, меньшие, чем заданный");
        info.put("sort", "sort : отсортировать коллекцию в естественном порядке");
        info.put("print_label", "print_label : вывести значения поля label всех элементов в порядке возрастания");
        info.put("remove_by_label", "remove_by_label : удалить из коллекции все элементы, значение поля label которого эквивалентно заданному");
        info.put("count_by_label", "count_by_label label : вывести количество элементов, значение поля label которых больше заданного");

        keys = info.keySet();
        values = info.values();
        pairs = info.entrySet();
    }
}
