package java30;

/**
 * @author : ljg
 * @ClassName: WindowTest1
 * @Description 例子：创建三个窗口卖票，总票数一百张
 *                  创建线程方式二：实现Runnable接口
 *              线程安全问题：出现重票和错票
 *              原因：
 *              解决：同步机制，即pv操作
 *              方法一：同步代码块
 *                  synchronized(同步监视器){
 *                      //需要被同步的代码
 *
 *                  }
 *                  说明：操作共享数据的代码，即需要被同步的代码
 *                       同步监视器，即锁。任何一个类的对象，都可以充当锁
 *                                  可以考虑this作为锁,考虑唯一性问题
 *                       要求：多个线程必须要共用同一把锁
 *              方法二：同步方法
 *                  如果操作共享数据的代码完整在一个方法中，则可以将该方法声明为同步的
 *
 *              总结：解决了线程安全问题，但操作同步代码时只能有一个线程，即单线程过程
 * @date : 2022/4/25 9:53
 */
class Window1 implements Runnable {
    //只new了一个对象供三个线程抢用
    private static int ticket = 200;
    //作为锁
   private static Object obj = new Object();

    @Override
    public void run() {
//        Object obj = new Object();
        while (true) {
            //直接采用当前Window1对象作为锁
            //synchronized (this) {
            //synchronized (obj) {
            //即Class class = Window1.class,只会加载一次
            synchronized (Window1.class) {
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
            }

        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        t1.setName("线程一");
        t1.start();

        Thread t2 = new Thread(w);
        t2.setName("线程二");
        t2.start();

        Thread t3 = new Thread(w);
        t3.setName("线程三");
        t3.start();
    }
}
