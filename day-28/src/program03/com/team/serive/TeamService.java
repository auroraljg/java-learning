package program03.com.team.serive;

import jdk.jfr.Description;
import program03.com.team.domain.Architect;
import program03.com.team.domain.Designer;
import program03.com.team.domain.Employee;
import program03.com.team.domain.Programmer;

/**
 * @author : ljg
 * @ClassName: TeamService
 * @Description T关于开发团队成员的管理：添加、删除等。
 * counter: int = 1
 * MAX_MEMBER: final int = 5
 *  team: Programmer[] = new Programmer[MAX_MEMBER];
 * - total: int = 0;
 *
 * getTeam(): Programmer[]
 * + addMember(e: Employee) throws TeamException: void
 * + removeMember(memberId: int) throws TeamException: void
 * 说明：
 * counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
 * MAX_MEMBER：表示开发团队最大成员数
 * team数组：用来保存当前团队中的各成员对象
 * total：记录团队成员的实际人数
 * @date : 2022/4/22 17:41
 */
public class TeamService {
    private static int count = 1; //为开发团队新增成员自动生成团队中的唯一ID，即memberId
    private final int MAX_MEMBER = 5; //表示开发团队最大成员数
    private Programmer[] team = new Programmer[MAX_MEMBER]; //用来保存当前团队中的各成员对象
    private  int total = 0; //记录团队成员的实际人数

    public TeamService() {
    }

    /*
     * Description: 返回当前团队的所有对象
     * @param: []
     * @return: 包含所有成员对象的数组，数组大小与成员人数一致
     * @author: ljg
     * @date: 2022/4/22 17:49
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0;i < team.length;i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /*
     * Description:向团队中添加成员,异常：添加失败， TeamException中包含了失败原因
     * @param: 待添加成员的对象
     * @return: void
     * @author: ljg
     * @date: 2022/4/22 17:49
     */
    public void addMember(Employee e) throws TeamException {

//        成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
//        该员工已在本开发团队中
        //因为需要用到循环，则需要用方法封装一下更合适
        if (isExit(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
//        该员工已是某团队成员

//        该员正在休假，无法添加
        Programmer p = (Programmer) e; // 异常的处理是循环渐进的
        //与if (p.getStatus().getNAME().equalsIgnoreCase(BUSY))相比，减少了空指针异常的风险
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) { //
            throw new TeamException("该员工已是某团队成员");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该员正在休假，无法添加");
        }

//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        int numOfArch = 0,numOfDes = 0,numOfPro = 0;
        //计算了现有团队的架构师、设计师、程序员人数
        for (int i = 0;i < total;i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        //嵌套写的原因是避免存在一个架构师加入两个设计师的团队情况
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        //将p添加到现有的team
        team[total++] = p;
        p.setMemberId(count++);
        p.setStatus(Status.BUSY);

    }

    /*
     * Description: 判断该员工是否在本开发团队中
     * @param: [e]
     * @return: boolean
     * @author: ljg
     * @date: 2022/4/22 18:03
     */
    private boolean isExit(Employee e) {
        for (int i = 0;i < total;i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    /*
     * Description:从团队中删除成员,异常：找不到指定memberId的员工，删除失败
     * @param:待删除成员的memberId
     * @return:void
     * @author: ljg
     * @date: 2022/4/22 20:46
     */
    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0;i < total;i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //未找到指定memberId的员工
        if (i == total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        //删除一个元素：后面元素覆盖前一个元素，最后一个置空
        for (int j = i + 1;j < total;j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;
    }

}
