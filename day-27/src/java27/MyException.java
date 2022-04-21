package java27;

/**
 * @author : ljg
 * @ClassName: MyException
 * @Description
 *      如何自定义异常类：
 *          1.继承于现有的异常结构：RuntimeException、Exception
 *          2.提供全局常量：serialVersionUID
 *          3.提供几个重载的构造器
 * @date : 2022/4/21 16:53
 */
public class MyException extends RuntimeException{
    static final long serialVersionUID = -2659685695263265695L;

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}
