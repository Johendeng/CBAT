import com.yk.cbat.service.RedisServiceImpl.RedisServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by JohenTeng on 2017/8/29.
 */

@org.junit.runner.RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-common.xml"})
public class ResistOpTest {
    @Autowired
    private RedisServiceImpl redisService;
    @Test
    public void getDataBykeyTest(){

        final String key = "mykey";
        String res = redisService.getData(key);
        System.out.println(res);
    }


}
