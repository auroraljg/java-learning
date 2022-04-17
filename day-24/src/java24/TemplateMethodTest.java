package java24;

/**
 * @author : ljg
 * @ClassName: TemplateMethodTest
 * @Description 模板方法的设计模式
 *
 * @date : 2022/4/17 17:32
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        //多态性
        TemplateMethod t = new SubTemplateMethod();
        t.spendTime();
    }

}
//抽象类
abstract class TemplateMethod{
    //计算某段代码执行所需时间
    public void spendTime(){
        long start = System.currentTimeMillis();

        this.code();//不确定、易变的部分

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));

    }
    //抽象方法
    public abstract void code();
}

class SubTemplateMethod extends TemplateMethod{
    public void code(){
        for(int i = 0;i <= 1000;i++){
            boolean isFlag = true;
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){
                System.out.println(i);
            }
        }
    }
}