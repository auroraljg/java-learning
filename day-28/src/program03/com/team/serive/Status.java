package program03.com.team.serive;

/**
 * @author : ljg
 * @ClassName: Status
 * @Description 声明三个对象属性，分别表示成员的状态。
 * @date : 2022/4/22 9:08
 */
public class Status {

    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
