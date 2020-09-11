package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例演示
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        //配置xml配置文件。启动spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //依赖来源一：自定义的Bean
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);

        //此处是依赖注入（依赖来源二：内建依赖 (自己没有创建但是可以注入的Bean)）
        System.out.println(userRepository.getBeanFactory()); //由于配置了 autowire = 'byType' 所以此处不为null，注入的是内建的对象(容器)
//        System.out.println(beanFactory == userRepository.getBeanFactory());

        //此处是依赖查找 (会报错，没有定义 BeanFactory 类型的Bean )
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        //依赖注入,依赖查找 注入的bean的来源？？？  自定义Bean,容器内建Bean对象,容器内建依赖
        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject()==beanFactory); //true

        //依赖来源三：容器内建 Bean(容器默认初始化的一些Bean)
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);
    }



}
