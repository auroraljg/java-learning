package java29;

/**
 * @author : ljg
 * @ClassName: ThreadMethodTest
 * @Description
 * Thread类的有关方法(1)
 * void start(): 启动线程，并执行对象的run()方法
 * run(): 线程在被调度时执行的操作
 * currentThread()：静态方法，返回执行当前代码的线程
 * String getName(): 返回线程的名称
 * void setName(String name):设置该线程名称
 * static Thread currentThread(): 返回当前线程。在Thread子类中就是this，通常用于主线程和Runnable实现类
 * static void yield()：线程让步,但存在可能下一次cpu使用权还是分配到该线程
 *          暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程
 *          若队列中没有同优先级的线程，忽略此方法
 * join() ：当某个程序执行流中调用其他线程的 join() 方法时，调用线程将
 *              被阻塞，直到 join() 方法加入的 join 线程执行完为止
 *          低优先级的线程也可以获得执行
 * static void sleep(long millis)：(指定时间:毫秒)
 * 令当前活动线程在指定时间段内放弃对CPU控制,使其他线程有机会被执行,时间到后
 *      重排队。
 * 抛出InterruptedException异常
 * stop(): 强制线程生命期结束，不推荐使用
 * boolean isAlive()：返回boolean，判断线程是否还活着
 * @date : 2022/4/24 20:36
 */
class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

//            if (i % 10 == 0) {
//                this.yield ();
//            }


        }
    }
}

    public class ThreadMethodTest {
        public static void main(String[] args) {
            MyThread1 m1 = new MyThread1("线程一");
            //命名方式2
//        m1.setName("线程一");
            m1.start();

            //主线程命名
            Thread.currentThread().setName("主线程：");
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
                if (i == 50) {
                    try {
                        m1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(m1.isAlive());
        }
    }

