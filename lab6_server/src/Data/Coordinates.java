package Data;

public class Coordinates {
    private Long x; //Максимальное значение поля: 676, Поле не может быть null
    private int y; //Значение поля должно быть больше -177
    public void Seter(Long x, int y){
        this.x = x;
        this.y = y;
    }
    public Long GetX(){
        return this.x;
    }
    public int GetY(){
        return this.y;
    }
    public String toString(){
        return "Coordinates{" +
                "x='" + x +'\'' +
                ", y='" + y +'\''+
                '}';
    }
}