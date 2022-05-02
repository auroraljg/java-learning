package java31;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : ljg
 * @ClassName: ThreadNew
 * @Description 新增方式一：实现Callable接口
 *                  1.创建一个实现Callable的实现类
 *                  2.实现call（）方法，将此线程需要执行的操作声明在call方法中
 *                  3.创建Callable实现类的对象
 *                  4.将此实现类对象作为参数传递到FutureTask构造器中，创建FutureTask对象
 *                  5.将FutureTask对象作为参数传递到Thread类的构造器中，创建Thread对象并调用start方法
 *                  6.获取Call方法的返回值：FutureTask对象的get方法的返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值
 *              如何理解比实现runnable接口方法强大
 *                  1.call方法可以有返回值
 *                  2.可抛出异常，被外部操作捕获，获取异常信息
 *                  3.支持泛型
 *                  4.
 * @date : 2022/5/2 20:28
 */
class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();

        FutureTask futureTask = new FutureTask(numThread);

        new Thread(futureTask).start();

        try {
            //get方法的返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值
            Object sum =futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
