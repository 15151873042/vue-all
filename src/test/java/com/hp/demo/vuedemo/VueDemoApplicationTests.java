package com.hp.demo.vuedemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.script.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootTest
class VueDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        Connection connection = DriverManager.getConnection("jdbc:phoenix:10.1.192.229:2181/hbase-unsecure", new Properties());
        System.err.println(connection);
    }

}
