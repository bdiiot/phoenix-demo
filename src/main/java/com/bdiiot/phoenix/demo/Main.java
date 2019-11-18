package com.bdiiot.phoenix.demo;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String jdbc_url = "jdbc:phoenix:h11.bdiiot.com,h12.bdiiot.com,h13.bdiiot.com:2181:/hbase-secure:hbase-bdiiot@BDIIOT.COM:/etc/security/keytabs/hbase.headless.keytab";
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        Connection connection = DriverManager.getConnection(jdbc_url);
        Statement statement = connection.createStatement();

        String sql = "upsert into test.test_phoenix values (1,'a')";
        System.out.println(statement.executeUpdate(sql));
        connection.commit();

        sql = "select * from test.test_phoenix";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1).toString());
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
