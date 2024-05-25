package Data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicBand {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int numberOfParticipants; //Значение поля должно быть больше 0
    private Long albumsCount; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
    private Label label = new Label(); //Поле может быть null
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public MusicBand(
            Integer id,
            String name,
            String x, int y,
            String date,
            int numberOfParticipants,
            String albumsCount,
            String genre,
            String sales)
    {
        this.id = id;
        this.name = name;
        this.coordinates.Seter(Long.parseLong(x), y);
        try {
            this.creationDate = formatter.parse(date);
        }catch (Exception e){}
        this.numberOfParticipants = numberOfParticipants;
        this.albumsCount = Long.parseLong(albumsCount);
        this.genre = this.genre.valueOf(genre);
        this.label.Seter(Long.parseLong(sales));
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCord(long x, int y){
        this.coordinates.Seter(x, y);
    }
    public void setNum(int num){
        this.numberOfParticipants = num;
    }
    public void setAlbum(String num){
        this.albumsCount = Long.parseLong(num);
    }
    public void setGenre(String genre){
        this.genre = this.genre.valueOf(genre);
    }
    public void setLabel(String sales){
        this.label.Seter(Long.parseLong(sales));
    }
    public Integer GetID(){
        return this.id;
    }
    public String GetName(){
        return this.name;
    }
    public Coordinates GetCord(){
        return this.coordinates;
    }
    public java.util.Date GetDate(){
        return this.creationDate;
    }
    public int GetNum(){
        return this.numberOfParticipants;
    }
    public long GetAlbum(){
        return this.albumsCount;
    }
    public MusicGenre GetGenre(){
        return this.genre;
    }
    public Label GetLabel(){
        return this.label;
    }
    @Override
    public String toString(){
        return "MusicBand{" +
                "id='" + id +'\'' +
                ", name='" + name +'\''+
                ", coordinates='" + coordinates.toString() +'\''+
                ", creationDate='" +creationDate +'\''+
                ", numberOfParticipants='" + numberOfParticipants+'\''+
                ", albumsCount='" + albumsCount +'\''+
                ", genre='" + genre +'\''+
                ", label='" + label.toString() +'\''+
                '}';
    }
}
