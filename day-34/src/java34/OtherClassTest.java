package java34;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author : ljg
 * @ClassName: OtherClassTest
 * @Description TODO
 * @date : 2022/5/10 16:43
 */
public class OtherClassTest {
    @Test
    public void test2() {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);//java的version:17.0.1
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);//java的home:C:\Users\刘景刚\.jdks\openjdk-17.0.1
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);//os的name:Windows 10
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);//os的version:10.0
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);//user的name:刘景刚
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);//user的home:C:\Users\刘景刚
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);//user的dir:D:\learning\Java\project\javaSenior\day-34

    }
}
