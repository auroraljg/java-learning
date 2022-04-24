package java29;

/**
 * @author : ljg
 * @ClassName: java29.java29.ThreadTest
 * @Description
 * 多线程的创建：方法一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run方法
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()方法
 * @date : 2022/4/24 16:56
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread {

    //2.重写Thread类的run方法
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start()方法
        //start()方法作用：启用当前线程，并调用当前线程的run方法
        t1.start();
        //IllegalThreadStateException
//        t1.start();
        MyThread t2 = new MyThread();
        t2.start();


        //线程交错进行
        //如下操作在main线程中进行
        for (int i = 0; i < 1000; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + i + "*********main**********");
            }
        }
    }

}
