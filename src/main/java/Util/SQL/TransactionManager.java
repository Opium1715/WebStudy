package Util.SQL;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class TransactionManager {
    public static void beginTran() throws IOException {
         SqlConnector.getSqlSession();
    }

    public static void commitTran() throws IOException {
        SqlConnector.getSqlSession().commit();
        System.out.println("commit 提交事务");
        SqlConnector.SqlSessionClose();
    }

    public static void rollbackTran() throws IOException {
        SqlConnector.getSqlSession().rollback();
        SqlConnector.SqlSessionClose();

    }
}
