package org.zerock.springex.sample;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    // 스프링에서 사용하는 의존성 주입 관련 애너테이션
    // '만일 해당 타입의 빈(Bean)이 존재한다면 여기에 주입해 주기를 원한다는 의미
    // 변수는 Autowired로 넣는다.
    @Autowired
    private SampleService sampleService; // SampleService를 멤버 변수로 선언

    @Test
    public void testService1(){

        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection()throws Exception{
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);

        connection.close();
    }
}
