package jdk8;

/**
 * @author : ljg
 * @ClassName: CompareB
 * @Description TODO
 * @date : 2022/4/19 16:39
 */
public interface CompareB {
    default void method3() {   //省略public
        System.out.println("CompareA:上海2");
    }
}
