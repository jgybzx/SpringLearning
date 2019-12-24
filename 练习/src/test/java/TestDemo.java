import com.jgybzx.domain.Account;
import com.jgybzx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/23 19:57
 * @Description:
 * @version:
 */
public class TestDemo {
    @Test
    public void save(){
        //准备要保存的对象
        Account account = new Account();
        account.setName("jgyzbx");
        account.setMoney(121212D);
        //获取service对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.save(account);
    }
    @Test
    public void update(){
        //准备要修改的对象
        Account account = new Account();
        account.setId(2);
        account.setName("jgyzbx啊洒洒");
        account.setMoney(121212D);
        //获取service对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.update(account);
    }
    @Test
    public void delete(){
        //准备要删除的id
        Integer id = 3;
        //获取service对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.delete(id);
    }
    @Test
    public void findall(){
        //获取service对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        List<Account> list = accountService.findall();
        System.out.println("list = " + list);
    }
    @Test
    public void findById(){
        //准备要保存的对象
        Integer id = 1;
        //获取service对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext*");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        Account account = accountService.findById(id);
        System.out.println("account = " + account);
    }
}
