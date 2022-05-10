package java34;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : ljg
 * @ClassName: CompareTest
 * @Description 在Java中经常会涉及到对象数组的排序问题，那么就涉及到对象之间
 * 的比较问题。
 *  Java实现对象排序的方式有两种：
 *  自然排序：java.lang.Comparable
 *  定制排序：java.util.Comparator
 * 二、Comparable接口使用
 *
 *
 * @date : 2022/5/9 17:46
 */
public class CompareTest {
    @Test
    public void test4() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("xiaomi",4526);
        arr[4] = new Goods("huawei",6026);
        arr[2] = new Goods("lianxiang",8562);
        arr[3] = new Goods("huashuo",3589);
        arr[1] = new Goods("weiruan",6026);
        arr[5] = new Goods("weiruan",8525);


        Arrays.sort(arr, new Comparator<Goods>() {
            //先按照名称从低到高，在按照价格从高到低
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName() == o2.getName()) {
                    return - Double.compare(o1.getPrice(),o2.getPrice());
                }else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        System.out.println(Arrays.toString(arr));
    }
    /*
     * Description: 定制排序：java.util.Comparator
     *                    1.当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
                            或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
                            么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排
                            序的比较。
                          2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返
                            回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示o1小于o2。
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/10 16:21
     */
    @Test
    public void test3() {
        String[] arr = new String[]{"aa","dd","bb","DD","AA","zz"};
        //字符串从大到小的顺序排列
        //匿名实现类
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { //不用强转
                return - o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));//[zz, dd, bb, aa, DD, AA]
    }
    /*
     * Description:对于自定类需要实现Comparable接口，重写CompareTo方法
     *              在该方法中写明比较的类型
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/10 11:16
     */
    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("xiaomi",4526);
        arr[4] = new Goods("huawei",6026);
        arr[2] = new Goods("lianxiang",8562);
        arr[3] = new Goods("huashuo",3589);
        arr[1] = new Goods("weiruan",6026);


        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
    /*
     * Description:Comparable接口使用
     *                  1.像String类、包装类等实现了该接口，重写了CompareTo方法，给出了比较两个对象的大小
     *                  2.重写CompareTo（obj）方法规则：
     *                      this大于obj返回正整数，等于返回0，小于返回负整数
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/9 17:48
     */
    @Test
    public void test1() {
        //String实现了Comparable接口的CompareTo方法
        String[] arr = new String[]{"aa","dd","bb","DD","AA","zz"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));//[AA, DD, aa, bb, dd, zz]
    }
}
