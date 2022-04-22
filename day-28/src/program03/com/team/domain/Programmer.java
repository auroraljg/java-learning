package program03.com.team.domain;

import program03.com.team.serive.Status;

/**
 * @author : ljg
 * @ClassName: Programmer
 * @Description TODO
 * @date : 2022/4/22 9:05
 */
public class Programmer extends Employee{
    private int memberId; //团队id
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
// 3      李彦宏   23       7000.0    程序员   FREE                                戴尔(NEC17寸)
    //对象在调用时若未重写tostring()则是调用对象的地址值
    @Override
    public String toString() {
        return getDetail() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }
    //供团队成员调用
    //2/4     刘强东   24      7300.0    程序员
    public String teamToString() {
        return memberId + "/" + getId() + "\t\t" + getName() + "\t" +getAge() + "\t\t" + getSalary() + "\t程序员\t";
    }
}
