package program03.com.team.domain;

/**
 * @author : ljg
 * @ClassName: NoteBook
 * @Description TODO
 * @date : 2022/4/22 8:54
 */
public class NoteBook implements Equipment{
    private String model;  //笔记本型号
    private double price; //价格

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
