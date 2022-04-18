package java25;

/**
 * @author : ljg
 * @ClassName: NetWorkTest
 * @Description 接口的应用：代理模式
 *                  1.通过被代理类的对象的方法来实现代理类的方法，(加点私活)
 * @date : 2022/4/18 20:56
 */
public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();   //实例化被代理类对象
        ProxyServer proxyServer = new ProxyServer(server);  //实例化代理类对象

        proxyServer.browse();

    }
}
//接口
interface NetWork {
    //抽象方法
    public void browse();

}
//被代理类
class Server implements NetWork {

    @Override
    public void browse() {
        System.out.println("真实的服务器访问速度");
    }
}
//代理类
class ProxyServer implements NetWork {

    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("联网之前的检查");
    }

    @Override
    public void browse() {
        check();

        work.browse();
    }
}