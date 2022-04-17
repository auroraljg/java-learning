package java24;

/**
 * @author : ljg
 * @ClassName: SingleTest
 * @Description TODO
 * @date : 2022/4/17 10:55
 */
public class SingleTest {
}
//饿汉式
class A{
    private A(){

    }

    private static A Instance = new A();

    public static A getInstance(){
        return Instance;
    }

}

//懒汉式
class B{
    private B(){

    }

    private static B Instance ;

    public static B getInstance(){
        if(Instance == null){
            Instance = new B();
        }
        return Instance;
    }
}