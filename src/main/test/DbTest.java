import com.yk.cbat.entity.User;
import com.yk.cbat.service.UserService;
import com.yk.cbat.util.PageUtil;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by JohenTeng on 2017/8/31.
 */


@org.junit.runner.RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-common.xml"})
public class DbTest {
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @Test
    public void userTest(){
        PageUtil<User> page = new PageUtil<>();

        List<User> userArr = userService.getUserByPage(page);
        System.out.println(userArr.size());
    }




}
