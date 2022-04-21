package exer;

//自定义对应输入负数的异常类(EcDef)
public class EcDef extends Exception {
    static final long serialVersionUID = -2659455695263265695L;


    public EcDef() {
    }
    public EcDef(String message) {
        super(message);
    }

}
