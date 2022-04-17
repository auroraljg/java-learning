package exer;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author : ljg
 * @ClassName: PayrollSystem
 * @Description 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
 * 类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类
 * 型,name,number,birthday。当键盘输入本月月份值时，如果本
 * 月是某个Employee对象的生日，还要输出增加工资信息。
 * @date : 2022/4/17 18:24
 */
public class PayrollSystem {
    public static void main(String[] args) {

        //创建Employee变量数组并初始化
        Employee[] employees = new Employee[3]; //声明了一个数组，每个数组元素是employees型

        employees[0] = new SalariedEmployee("JOKE",1002,new MyDate(1998,5,3),9500);
        employees[1] = new HourlyEmployee("TOM",1003,new MyDate(1999,4,25),30,15);
        employees[2] = new SalariedEmployee("KOM",1004,new MyDate(1996,6,15),13500);

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入当前月份：" );
//        int month = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;

        //利用循环结构遍历数组元素
        for (int i = 0;i < employees.length;i++){

            //输出各个对象的类型,name,number,birthday,以及该对象生日
            System.out.println(employees[i]);

            //当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
            double salary = employees[i].earnings();
            if(employees[i].getBirthday().getMonth() == month){
                salary += 100;
                System.out.println("生日快乐，奖励一百元，月工资为：" + salary);
            }else{
                System.out.println("月工资为：" + salary);
            }
        }
    }
}
