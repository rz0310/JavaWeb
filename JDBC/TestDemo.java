package JDBC;

import org.junit.Test;

import java.sql.SQLException;

public class TestDemo {
    @Test
    public void test() throws SQLException, ClassNotFoundException {
        JDBCDemo1 jd = new JDBCDemo1();
        jd.QueryAll();
//        jd.delete();
        jd.insert();
    }
}
