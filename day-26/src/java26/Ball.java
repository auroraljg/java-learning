package java26;

/**
 * @author : ljg
 * @ClassName: Ball
 * @Description TODO
 * @date : 2022/4/19 10:48
 */
interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable,Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name;
    }
    public Ball(String name) {
        this.name = name;
    }
    public void play() {     //不知重写了哪一个接口的方法
//        ball = new Ball("Football");  //全局常量
        System.out.println(ball.getName());
    }
}
