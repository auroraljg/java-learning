package java25;

/**
 * @author : ljg
 * @ClassName: UsbTest
 * @Description 8.接口的具体使用，体现多态性
 *                  1.满足多态性的使用
 *                  2.开发中体会 面向接口编程
 * @date : 2022/4/18 10:48
 */
public class UsbTest {
    public static void main(String[] args) {

        Computer computer = new Computer();

        //1.创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        computer.transferDate(flash);

        //2.创建了接口的非匿名实现类的匿名对象
        computer.transferDate(new Flash());

        //3.创建了接口的匿名实现类的非匿名对象
        Usb phone = new Usb() {
            @Override
            public void start() {
                System.out.println("phone开始工作");
            }

            @Override
            public void end() {
                System.out.println("phone结束工作");
            }
        };
        computer.transferDate(phone);

        //4.创建了接口的匿名实现类的匿名对象
        computer.transferDate(new Usb() {
            @Override
            public void start() {
                System.out.println("mp3开始工作");
            }

            @Override
            public void end() {
                System.out.println("mp3开始工作");
            }
        });

    }
}

class Computer {
    public void transferDate(Usb usb) {   //Usb usb = new Flash();
        usb.start();

        System.out.println("具体传输");

        usb.end();
    }
}
interface Usb {
    //常量，规定了传输细节

    void start();

    void end();
}

//实现类
class Flash implements Usb {

    @Override
    public void start() {
        System.out.println("usb开始工作");
    }

    @Override
    public void end() {
        System.out.println("usb停止工作");
    }
}