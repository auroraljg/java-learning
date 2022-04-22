package program03.com.team.serive;

/**
 * @author : ljg
 * @ClassName: TeamException
 * @Description 声明异常类步骤
 * 1.继承异常类
 * 2.声明静态UID
 * 3.重写构造器
 * @date : 2022/4/22 16:42
 */
public class TeamException extends RuntimeException{
    static final long serialVersionUID = -1548564654158418541L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
