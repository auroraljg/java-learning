package exer;

import org.testng.annotations.Test;

/**
 * @author : ljg
 * @ClassName: IdeaDebug
 * @Description TODO
 * @date : 2022/5/5 16:54
 */
public class IdeaDebug {
    @Test
    public void test() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//NullPointerException

    }
}
