package com.ice.springboot.text;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataSource {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection (){
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection);

        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
