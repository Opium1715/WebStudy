package Servlet;

import Ioc.BeanFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {
//    private Map<String,Object> beanObjectMap=new HashMap<>();
    private BeanFactory beanFactory;
    public DispatcherServlet() {}

    @Override
    public void init() throws ServletException {
        super.init();
//        beanFactory = new ClassPathXmlApplicationContext();
        ServletContext Application= getServletContext();
        beanFactory= (BeanFactory) Application.getAttribute("beanFactory");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        req.setCharacterEncoding("UTF_8");

        String ServletPath= req.getServletPath().substring(1,req.getServletPath().lastIndexOf(".do"));

        System.out.println(ServletPath);

        req.setAttribute("ServletPath",ServletPath);//为了选表查询

        Object controllerBeanObj= beanFactory.getBean(ServletPath);

        String operate =req.getParameter("operate");

        if(operate==null){//have a problem, be careful

            operate="Display"+ServletPath;
        }

        Method[] methods= controllerBeanObj.getClass().getDeclaredMethods();

        for(Method method:methods){
            String methodName=method.getName();
            if(operate.equals(methodName)){
                try {
                    //1.统一获取请求参数
                    Parameter[] parameters= method.getParameters();
                    Object[] parameterValues= new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        String ParameterName=parameters[i].getName();
                        switch (ParameterName) {
                            case "req":
                                parameterValues[i] = req;
                                break;
                            case "resp":
                                parameterValues[i] = resp;
                                break;
                            case "session":
                                parameterValues[i] = req.getSession();
                                break;
                            default:
                                String typeName = parameters[i].getType().getTypeName();
                                Object ParameterValue = req.getParameter(ParameterName);

                                if (typeName.equals("java.lang.Integer")) {
                                    if(ParameterValue!=null){
                                        if(!ParameterValue.toString().isEmpty()){
                                            parameterValues[i] = Integer.parseInt(req.getParameter(ParameterName));
                                        }
                                    }
                                } else if (typeName.equals("java.lang.Double")) {
                                    if(ParameterValue!=null){
                                        if(!ParameterValue.toString().isEmpty()){
                                            parameterValues[i]=Double.parseDouble(req.getParameter(ParameterName));
                                        }
                                    }
                                } else {
//                                    if(!ParameterValue.toString().isEmpty())
                                        parameterValues[i] = ParameterValue;
                                }

                                break;
                        }

                    }



                    //2.controller组件中的方法调用
                    Object methodReturn = method.invoke(controllerBeanObj,parameterValues);

                    //3.页面视图处理
                    String returnValue = (String) methodReturn;
                    if(returnValue==null){return;}
                    if(returnValue.startsWith("redirect:")){
                        String redirectStr=returnValue.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    } else if (returnValue.startsWith("json:")) {
                        String jsonStr = returnValue.substring("json:".length());
                        resp.setContentType("application/json;charset=UTF-8");
                        PrintWriter writer = resp.getWriter();
                        writer.print(jsonStr);
                        writer.flush();
                    } else {
                        super.processTemplate(returnValue,req,resp);
                    }
//                    return;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
//            Method method= controllerBeanObj.getClass().getDeclaredMethod(operate, HttpServletRequest.class);


        //        //获取当前类中的所有方法
//        Method[] methods= controllerBeanObj.getClass().getDeclaredMethods();
//        for(Method method:methods){
//            String methodName=method.getName();
//            if(operate.equals(methodName)){
//                try {
//                    method.invoke(method,req,resp);
//                    return;
//                } catch (IllegalAccessException | InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
    }
}
