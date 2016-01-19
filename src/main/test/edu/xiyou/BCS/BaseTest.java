package edu.xiyou.BCS;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by andrew on 15-12-15.
 */
@ContextConfiguration(locations= {"classpath*:conf/spring.xml", "classpath*:conf/spring-mybatis.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests{
    /*static {
        try {
            Log4jConfigurer.initLogging("classpath:conf/log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }*/
}
