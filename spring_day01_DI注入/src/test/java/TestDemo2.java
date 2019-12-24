import com.jgybzx.domain.People;
import com.jgybzx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: guojy
 * @date: 2019/12/23 12:15
 * @Description:
 * @version:
 */
public class TestDemo2 {
    @Test
    public void test(){
        //解析配置文件
        /*ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.save();*/
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = (People) as.getBean("people");
        System.out.println(people);
    }

}
