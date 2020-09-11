package org.geekbang.thinking.in.spring.ioc.overview.container;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 注解能力{@link ApplicationContext} ApplicationContext 作为  IOC容器示例
 */
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {

        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类(Configuration Class)
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        lookupCollectionByType(applicationContext);

        //关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(2L);
        user.setName("张杰1");
        return user;
    }


    //查找集合对象(一个类，有多个对象)
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + userMap);
        }
    }
}
