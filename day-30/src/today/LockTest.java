package today;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ljg
 * @ClassName: 解决线程安全问题方式三：LOCK
 *                  1.实例化ReentrantLock
 *                  2.调用锁定方法
 *                  3.调用解锁方法，通常用try-finally结构保证肯定解锁
 * @date : 2022/4/30 10:16
 */
class Window implements Runnable {
    private int ticket = 100;

    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //调用锁定方法
                lock.lock();
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {

                //调用解锁方法
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
