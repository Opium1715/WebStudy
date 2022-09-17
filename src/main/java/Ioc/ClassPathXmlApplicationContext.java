package Ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext implements BeanFactory{

    private final Map<String, Object> beanMap = new HashMap<>();

    public ClassPathXmlApplicationContext(){
        try {
            String path = "applicationContext.xml";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
            Document document= documentBuilder.parse(inputStream);
            //获取所有bean节点
            NodeList nodeList=document.getElementsByTagName("bean");
            //bean节点实例化注入容器
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node beanNode= nodeList.item(i);
                if(beanNode.getNodeType()==Node.ELEMENT_NODE){
                    Element beanElement=(Element) beanNode;
                    String beanId= beanElement.getAttribute("id");
                    String className=beanElement.getAttribute("class");
                    Object beanObj=Class.forName(className).newInstance();

                    beanMap.put(beanId,beanObj);
                }
            }
            //实例依赖关系组装
            for (int i = 0; i < nodeList.getLength(); i++){
                Node beanNode= nodeList.item(i);
                if(beanNode.getNodeType()==Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    NodeList beanChildNodeList = beanElement.getChildNodes();
                    for (int j = 0; j < beanChildNodeList.getLength(); j++) {
                        Node beanChildNode = beanChildNodeList.item(j);
                        if(beanChildNode.getNodeType()==Node.ELEMENT_NODE && beanChildNode.getNodeName().equals("property")){
                            Element propertyElement = (Element) beanChildNode;
                            String propertyName= propertyElement.getAttribute("name");
                            String propertyRef= propertyElement.getAttribute("ref");
                            Object refObj= beanMap.get(propertyRef);
                            Object beanObj=beanMap.get(beanId);
                            Field propertyField =beanObj.getClass().getDeclaredField(propertyName);
                            propertyField.setAccessible(true);
                            //给bean设置使用到的组件实例
                            propertyField.set(beanObj,refObj);
                        }
                    }
                }
            }


        } catch (SAXException | ParserConfigurationException | IOException | ClassNotFoundException |
                 InstantiationException | IllegalAccessException e) {
            System.out.println("解析配置文件错误！");
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
