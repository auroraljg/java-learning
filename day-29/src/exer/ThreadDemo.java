package exer;

/**
 * @author : ljg
 * @ClassName: ThreadDemo
 * @Description
 * 创建两个分线程，其中一个线程继承100以内偶数，另一个继承100以内奇数
 * @date : 2022/4/24 20:22
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //方法1
//        MyThread1 m1 = new MyThread1();
//        MyThread2 m2 = new MyThread2();
//
//        m1.start();
//        m2.start();
//
//        for (int i = 0;i < 1000;i++){
//            if (i % 2 !=0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//            }
//        }
        //方法2创建Thread类的匿名子类的方法
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();



    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 1000;i++){
            if (i % 2 ==0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 1000;i++){
            if (i % 2 !=0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}