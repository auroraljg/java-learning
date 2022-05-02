package exer;

/**
 * @author : ljg
 * @ClassName: ProductTest
 * @Description 。
 * 经典例题：生产者/消费者问题
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 * @date : 2022/5/2 19:13
 */
//店员
class Clerk{
    private int ProductCount = 0;

    //生产产品
    public synchronized void produceProduct() {
        if (ProductCount < 20) {
            ProductCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + ProductCount + "个产品");
            notifyAll();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (ProductCount > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + ProductCount + "个产品");
            ProductCount--;
            notifyAll();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//生产者
class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品...");
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
//消费者
class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品...");
        while (true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        Producer p2 = new Producer(clerk);
        p2.setName("生产者2");

        Customer c1 =new Customer(clerk);
        c1.setName("消费者1");
        Customer c2 =new Customer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
//        c2.start();
    }
}
