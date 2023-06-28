package com.demo.myspring.spring.Factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    private static Map<String,Object> BeanMap = new HashMap<String, Object>();

    static {
        //加载xml
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        //解析xml
        SAXReader reader = new SAXReader();

        try {
            //拿到xml
            Document document = reader.read(in);
            //拿到根元素
            Element root = document.getRootElement();

            List<Element> beanlistt = root.selectNodes("//bean");
            for (int i = 0; i < beanlistt.size(); i++) {
                Element element = beanlistt.get(i);
                String id = element.attributeValue("id");
                String aclass = element.attributeValue("class");
                Class<?> clazz = Class.forName(aclass);
                Object object = clazz.newInstance();
                BeanMap.put(id,object);
                System.out.println(BeanMap);
            }

            List<Element> propertylist= root.selectNodes("//property");
            for (int i = 0; i < propertylist.size(); i++) {
                Element proerty = propertylist.get(i);
                String name = proerty.attributeValue("name");
                String ref = proerty.attributeValue("ref");
                Element parent = proerty.getParent();
                String parentid = parent.attributeValue("id");
                Object object = BeanMap.get(parentid);

                Method[] method = object.getClass().getMethods();
                for (int j = 0; j < method.length ; j++) {
                    Method method1 = method[j];
                    if (("set"+name).equals(method1.getName())) {
                        method1.invoke(object,BeanMap.get(ref));
                    }
                }
                BeanMap.put(parentid,object);

            }


        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //根据id获取实例
    public static Object getbean(String name) {
        Object o = BeanMap.get(name);
        if (o == null) {
            throw new RuntimeException("无此实例");
        }
        return o;
    }
}
