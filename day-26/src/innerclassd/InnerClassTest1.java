package innerclassd;

/**
 * @author : ljg
 * @ClassName: InnerClassTest1
 * @Description 3.3局部内部类的使用
 * @date : 2022/4/19 20:45
 */
public class InnerClassTest1 {

    public void method() {
        //局部内部类
        class AA {

        }
    }

    //返回一个实现了Comparable接口的类的对象
    public Comparable getComparable() {

        //创建一个实现Comparable接口的类
        //方法1：
//        class MyComparable implements Comparable {
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();
        //方法2:匿名实现类的匿名对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
