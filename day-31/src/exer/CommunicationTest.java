package exer;

/**
 * @author : ljg
 * @ClassName: CommunicationTest
 * @Description 使用两个线程打印 1-100。线程1, 线程2 交替打印
 * 涉及的方法
 * wait() 当前进程进入阻塞态，并且释放同步监视器
 * notify() 唤醒被wait的一个线程，多个则只会唤醒优先级别高的
 * notifyAll() 唤醒被wait的所有线程
 *
 * 说明：
 *      1.该三种方法只能出现在同步代码块或者同步方法中
 *      2.该三种方法的调用者必须是同步代码块或同步方法的同步监视器
 *      3.该三种方法是定义在java.lang.Object类中
 *
 * sleep()方法与wait()方法的区别：
 *      相同点：执行该方法，可以使当前的线程进入阻塞状态
 *      不同点：1.声明的位置不同：前者在Thread类，后者在Object类
 *             2.调用要求不同：前者可在任何需要的场景中，后者只能在同步代码块
 *             3.若都在同步代码块中。sleep不会释放锁，后者则会
 * @date : 2022/5/2 10:47
 */
class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (number < 100){
                    //
                    notify();

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();

    }
}
