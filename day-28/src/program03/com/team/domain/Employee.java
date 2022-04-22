package program03.com.team.domain;

/**
 * @author : ljg
 * @ClassName: Employee
 * @Description TODO
 * @date : 2022/4/22 8:46
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
//1      马 云      22      3000.0
    @Override
    public String toString() {
        return id + "\t" + name +"\t" + age + "\t\t" + salary;
    }
    //方便子类的子类调用
    public String getDetail() {
        return id + "\t" + name +"\t" + age + "\t\t" + salary;
    }
}
