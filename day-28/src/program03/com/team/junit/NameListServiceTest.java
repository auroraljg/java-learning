package program03.com.team.junit;

import org.testng.annotations.Test;
import program03.com.team.domain.Employee;
import program03.com.team.serive.NameListService;
import program03.com.team.serive.TeamException;

/**
 * @author : ljg
 * @ClassName: NameListServiceTest
 * @Description 测试 NameListService类
 * @date : 2022/4/22 16:49
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees () {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0;i < employees.length;i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testgetEmployees (){
        NameListService service = new NameListService();
        int id = 5;

        try {
            Employee employee = service.getEmployees(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}
