package java30;

/**
 * @author : ljg
 * @ClassName: HelloJava
 * @Description
 * 线程的优先级
 *      1.MAX_PRIORITY：10
 *      2.MIN _PRIORITY：1
 *      3.NORM_PRIORITY：5
 * 涉及的方法
 * getPriority() ：返回线程优先值
 * setPriority(int newPriority) ：改变线程的优先级
 *  说明
 * 线程创建时继承父线程的优先级
 * 低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
 * @date : 2022/4/25 9:09
 */
class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }


    @Override
    public void run() {
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i + "." + Thread.currentThread().getPriority());
            }

//            if (i % 10 == 0) {
//                this.yield ();
//            }


        }
    }
}
public class HelloJava {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1("线程一");
        //命名方式2
//        m1.setName("线程一");
//        m1.setPriority(Thread.MAX_PRIORITY);
        m1.start();

        //主线程命名
        Thread.currentThread().setName("主线程：");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "." + Thread.currentThread().getPriority());
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
