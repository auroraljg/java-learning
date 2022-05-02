package java31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : ljg
 * @ClassName: ThreadPool
 * @Description 新增方式二：使用线程池
 *                  1.提供指定线程数量的线程池
 *                  2.执行指定的线程操作。需要提供实现Runnable接口或Callable接口实现类的对象
 *                  3.关闭线程池
 *
 * 优点：提高响应速度（减少了创建新线程的时间）
 *       降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *       便于线程管理
 *           corePoolSize：核心池的大小
 *           maximumPoolSize：最大线程数
 *           keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * @date : 2022/5/2 20:56
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
//        System.out.println(executorService.getClass());
        service.setCorePoolSize(12);
//        service.setKeepAliveTime();

        executorService.execute(new NumberThread());//执行任务/命令，没有返回值，一般用来执行Runnable
        executorService.execute(new NumberThread1());//执行任务/命令，没有返回值，一般用来执行Runnable

        //executorService.submit();//执行任务，有返回值，一般又来执行Callable

        executorService.shutdown();//关闭连接池
    }
}
