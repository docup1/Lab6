package Data;

public class Label {
    private Long sales; //Значение поля должно быть больше 0

    public void Seter(Long sales){
        this.sales = sales;
    }

    public Long GetSale(){
        return sales;
    }
    @Override
    public String toString(){
        return "Label{" + "sales='" + sales + '\'' + '}';
    }
}
