package Filter;

import Util.SQL.TransactionManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("OpenSessionInViewFilter begin");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        try{
            System.out.println("OpenSessionInViewFilter 开启事务");
            TransactionManager.beginTran();
            filterChain.doFilter(servletRequest, servletResponse);
            TransactionManager.commitTran();
            System.out.println("OpenSessionInViewFilter 提交事务");
        }catch (Exception e){
            TransactionManager.rollbackTran();
            System.out.println("OpenSessionInViewFilter 回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("OpenSessionInViewFilter end");
    }
}
