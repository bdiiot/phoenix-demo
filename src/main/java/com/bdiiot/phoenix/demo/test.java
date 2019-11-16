package com.bdiiot.phoenix.demo;

/**
 * http://phoenix.apache.org/faq.html#What_is_the_Phoenix_JDBC_URL_syntax
 * <p>
 * 1. Using console
 * <p>
 * Start Sqlline: $ sqlline.py [zookeeper]
 * Execute the following statements when Sqlline connects:
 * create table test (mykey integer not null primary key, mycolumn varchar);
 * upsert into test values (1,'Hello');
 * upsert into test values (2,'World!');
 * select * from test;
 * You should get the following output
 * +-------+------------+
 * | MYKEY |  MYCOLUMN  |
 * +-------+------------+
 * | 1     | Hello      |
 * | 2     | World!     |
 * +-------+------------+
 * 2. Using java
 * <p>
 * Create test.java file with the following content:
 */

import java.sql.*;

public class test {

    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;

        Connection con = DriverManager.getConnection("jdbc:phoenix:[zookeeper]");
        stmt = con.createStatement();

        stmt.executeUpdate("create table test (mykey integer not null primary key, mycolumn varchar)");
        stmt.executeUpdate("upsert into test values (1,'Hello')");
        stmt.executeUpdate("upsert into test values (2,'World!')");
        con.commit();

        PreparedStatement statement = con.prepareStatement("select * from test");
        rset = statement.executeQuery();
        while (rset.next()) {
            System.out.println(rset.getString("mycolumn"));
        }
        statement.close();
        con.close();
    }
}

/**
 * Compile and execute on command line
 *
 * $ javac test.java
 *
 * $ java -cp "../phoenix-[version]-client.jar:." test
 *
 * You should get the following output
 *
 * Hello World!
 */
