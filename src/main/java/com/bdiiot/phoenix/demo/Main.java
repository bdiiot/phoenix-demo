package com.bdiiot.phoenix.demo;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String jdbc_url = "jdbc:phoenix:bigdata.t01.58btc.com,bigdata.t02.58btc.com,bigdata.t03.58btc.com:2181:/hbase-secure:hbase-bd@58BTC.COM:/etc/security/keytabs/hbase.headless.keytab";
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        Connection connection = DriverManager.getConnection(jdbc_url);
        Statement statement = connection.createStatement();

        String sql = "upsert into test.test_hbase values (1,'a','2019','2019')";
        System.out.println(statement.executeUpdate(sql));
        connection.commit();

        sql = "select * from test.test_hbase";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1).toString());
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
