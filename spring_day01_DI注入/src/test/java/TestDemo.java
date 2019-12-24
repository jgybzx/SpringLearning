import com.jgybzx.service.UserService;
import com.jgybzx.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author: guojy
 * @date: 2019/12/23 11:45
 * @Description:
 * @version:
 */
public class TestDemo {
    private static  Map<String,Object> map = new HashMap<String, Object>();
    static {

        ResourceBundle bean = ResourceBundle.getBundle("bean");
        //取出配置文件所有key的className
        Set<String> classNameKeys = bean.keySet();
        for (String classNameKey : classNameKeys) {
            //遍历创建对象，添加到集合
            String className = bean.getString(classNameKey);
            Object o = null;
            try {
                 o= Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.put(classNameKey,o);
        }

    }
    public static void main(String[] args) throws Exception {
       /* UserService userService = new UserServiceImpl();
        userService.save();*/
       //多例
        /*UserService userService = (UserService) getBean("UserService");
        userService.save();*/

        //单例
        UserService userService = (UserService)map.get("UserService");
        UserService userService1= (UserService)map.get("UserService");
        UserService userService2 = (UserService)map.get("UserService");
        System.out.println(userService);
        System.out.println(userService1);
        System.out.println(userService2);
    }

    public static Object getBean(String className) throws Exception {
        ResourceBundle bean = ResourceBundle.getBundle("bean");
        String userService = bean.getString(className);
        return Class.forName(userService).newInstance();
    }
}
