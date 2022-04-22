package program03.com.team.domain;


/**
 * @author : ljg
 * @ClassName: Designer
 * @Description TODO
 * @date : 2022/4/22 12:13
 */
public class Designer extends Programmer {
    private double bonus; //奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    // 5      雷军      28       10000.0  设计师   FREE    5000.0                 佳能 2900(激光)
    //super.super.toString()是错误的
    //getDetail()
    @Override
    public String toString() {
        return getDetail() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }
    //5/12   杨致远   27      600.0      设计师   4800.0
    public String teamToString() {
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t" +getAge() + "\t\t"
                + getSalary() + "\t设计师\t" + getBonus();
    }
}
