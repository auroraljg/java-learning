package java24;

/**
 * @author : ljg
 * @ClassName: Employee
 * @Description 编写一个Employee类，声明为抽象类，
 * 包含如下三个属性：name，id，salary。
 * 提供必要的构造器和抽象方法：work()。
 * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
 * 请使用继承的思想，设计CommonEmployee类和Manager类，要求类
 * 中提供必要的方法进行属性访问。
 * @date : 2022/4/17 16:30
 */
public abstract class Employee {
    private String names;
    private int id;
    private int salary;

    public Employee() {
    }

    public Employee(String names, int id, int salary) {
        this.names = names;
        this.id = id;
        this.salary = salary;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    public abstract void work();  //抽象方法

}

class Manager extends Employee{
    private int bonus;

    public Manager() {
    }

    public Manager(String names, int id, int salary) {
        super(names, id, salary);
    }

    public Manager(String names, int id, int salary, int bonus) {
        super(names, id, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public  void work(){
        System.out.println("管理员工");
    };
}

class CommonEmployee extends Employee{
    public  void work(){
        System.out.println("员工一线工作");
    };
}