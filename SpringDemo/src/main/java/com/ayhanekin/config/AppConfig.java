package com.ayhanekin.config;

import com.ayhanekin.Alien;
import com.ayhanekin.Computer;
import com.ayhanekin.Desktop;
import com.ayhanekin.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.ayhanekin")
public class AppConfig {

//    private Alien alien;
//
//    @Bean(name = "desktop")
//    @Scope("prototype")
//    public Desktop desktop() {
//        return new Desktop();
//    }
//
//    @Bean(name = "laptop")
//    @Scope("prototype")
//    public Laptop laptop() {
//        return new Laptop();
//    }
//
//    @Bean(name = "alien")
//    @Scope("singleton")
//    public Alien alien(@Autowired @Qualifier("desktop") Computer computer) {
//        Alien alien = new Alien();
//        alien.setAge(25);
//        alien.setComputer(computer);
//        return alien;
//    }

}
