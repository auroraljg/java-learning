package program03.com.team.serive;

import program03.com.team.domain.*;

import static program03.com.team.serive.Data.*;

/**
 * @author : ljg
 * @ClassName: NameListService
 * @Description 功能：负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * 说明：
 * employees用来保存公司所有员工对象
 * NameListService()构造器：
 * Data类位于com.atguigu.team.service包中
 * @date : 2022/4/22 12:18
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
//        1.根据项目提供的Data类构建相应大小的employees数组
        employees = new Employee[EMPLOYEES.length];
//        2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//        3.将对象存于数组中
        for (int i = 0;i < employees.length;i++) {
            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取员工基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            int salary = Integer.parseInt(EMPLOYEES[i][4]);
            //只声明，不处理，原因是可能出现角标越界
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }

    }
    //获取指定index下的装备信息
    private Equipment createEquipment(int i) {
        int type = Integer.parseInt(EQUIPMENTS[i][0]);

        switch (type) {
            case PC:
                //返回一个匿名子类对象
                return new PC(EQUIPMENTS[i][1],EQUIPMENTS[i][2]);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[i][2]);
                return new NoteBook(EQUIPMENTS[i][1],price);
            case PRINTER:
                return new Printer(EQUIPMENTS[i][1],EQUIPMENTS[i][2]);
                //取消break原因是因为之前就有返回，程序进行不到break部分
//                break;
        }
        return null;
    }
//getAllEmployees ()方法：获取当前所有员工。
//返回：包含所有员工对象的数组
    public Employee[] getAllEmployees() {
        return employees;
    }
//getEmployee(id : int)方法：获取指定ID的员工对象。
//参数：指定员工的ID
//返回：指定员工对象
//异常：找不到指定的员工
    public Employee getEmployees(int id) throws TeamException{
        for (int i = 0;i < employees.length;i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        //抛出异常
        throw new TeamException("找不到指定的员工");
    }
}
