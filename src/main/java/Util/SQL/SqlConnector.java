package Util.SQL;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlConnector {
    static final ThreadLocal<SqlSession> threadLocal= new ThreadLocal<>();
    public static SqlSession SqlInit() throws IOException {
        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //返回sql会话工厂
//
        return sqlSessionFactory.openSession();
    }

    public static SqlSession getSqlSession() throws IOException {
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession==null){
            sqlSession=SqlInit();
            threadLocal.set(sqlSession);
        }
        return threadLocal.get();
    }

    public static void SqlSessionClose(){
       SqlSession sqlSession=threadLocal.get();
       if(sqlSession!=null){
           sqlSession.close();
           threadLocal.set(null);
           System.out.println("关闭连接会话");
       }
    }
}
