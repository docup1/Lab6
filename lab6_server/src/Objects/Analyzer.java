package Objects;

public class Analyzer {
    private String task;
    private String arguments [];
    private String[] words;
    public Analyzer(String comand){
        this.words = comand.split(" ");
        arguments = new String[this.words.length - 1];
        this.task = this.words[0];
        if(this.words.length > 1){
            for(int i = 1; i < this.words.length; i++){
                arguments [i - 1] = words[i];
            }
        }
    }
    public String[] getArgument(){
        return arguments;
    }
    public String getTask(){
        return this.task;
    }
}
