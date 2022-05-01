package java30;

/**
 * @author : ljg
 * @ClassName: WindowTest2
 * @Description 方法二：同步方法
 *                  1.同步方法仍涉及到同步监视器，只是不需要我们显式声明
 *                  2.非静态的同步方法：同步监视器为this
 *                  3.静态的同步方法：同步监视器为当前类本身
 */
class Window2 implements Runnable {
    //只new了一个对象供三个线程抢用
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket != 0) {
           show();
        }
    }
    //同步监视器：this
    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();

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
