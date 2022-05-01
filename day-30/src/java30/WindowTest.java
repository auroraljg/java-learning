package java30;

/**
 * @author : ljg
 * @ClassName: WindowTest
 * @Description 例子：创建三个窗口卖票，总票数一百张
 *                  1.存在线程安全
 * @date : 2022/4/25 9:28
 */
class Window extends Thread {
    //静态变量，多个线程共用
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ":卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }

}
