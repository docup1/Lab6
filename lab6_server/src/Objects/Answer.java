package Objects;

import java.io.Serializable;

public class Answer implements Serializable {
    private String text;
    public Answer(String text){
        this.text = text;
    }
    public String toString(){
        return text;
    }
}
