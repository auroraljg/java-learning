package java27;

/**
 * @author : ljg
 * @ClassName: StudentTest
 * @Description 手动抛出异常
 * @date : 2022/4/21 16:29
 */
public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.method(-1001);
            System.out.println(s);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
class Student {
    public int id;
    public void method(int id) throws Exception{
        if (id > 0) {
            this.id = id;
        }else {
//            System.out.println("你输入的数据非法！");
            //手动抛出异常
//            throw new RuntimeException("你输入的数据非法！");
//            throw new Exception("你输入的数据非法！");
            throw new MyException("不能输入负数");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}