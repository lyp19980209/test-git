package cn.smbms.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: smbmsproject
 * @description:
 * @author: lyp
 * @create: 2020-08-27 15:30:47
 **/
public class SpringContextUtil {

    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
}
