package java30;

/**
 * @author : ljg
 * @ClassName: WindowTest3
 * @Description TODO
 * @date : 2022/4/25 11:56
 */
class Window3 extends Thread {
    //静态变量，多个线程共用
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private static synchronized void show () {//同步监视器:Window3.class,唯一
        // private synchronized void show () {//同步监视器：w1,w2,w3不唯一
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }

}
