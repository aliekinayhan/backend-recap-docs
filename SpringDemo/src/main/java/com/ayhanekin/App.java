package com.ayhanekin;

import com.ayhanekin.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Alien alien = context.getBean(Alien.class);
        System.out.println(alien.getAge());
        alien.code();









        /*
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

                Desktop desktop = context.getBean(Desktop.class);
                desktop.compile();

                Desktop desktop1 = context.getBean("desktop1",Desktop.class);
                desktop1.compile();

                 */

        /*

        XML Config
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Alien alien = context.getBean("alien",Alien.class);
        alien.code();

        */

    }
}
