package java26;

/**
 * @author : ljg
 * @ClassName: C
 * @Description TODO
 * @date : 2022/4/19 10:41
 */
interface A {
    int x = 0;
}
class B {
    int x = 1;

}
class C extends B implements A {
    public void pX() {
//        System.out.println(x);
        System.out.println(super.x);  //1
        System.out.println(A.x);   //全局变量，0
    }
    public static void main(String[] args) {
        new C().pX();
    }
}
