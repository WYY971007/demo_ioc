package com.demo.myspring.controller;


import com.demo.myspring.service.TransferService;
import com.demo.myspring.spring.Factory.ProxyFactory;
import com.demo.myspring.utils.ConnectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transferServlet")
public class TransferServlet extends HttpServlet {

//    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//
//    private TransferService transferService = (TransferService)applicationContext.getBean("transferService");


    private TransferService transferService;

    @Override
    public void init() throws ServletException {
//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//
//        transferService = (TransferService)webApplicationContext.getBean("transferService");
//        ProxyFactory proxyFactory = (ProxyFactory)webApplicationContext.getBean("ProxyFactory");
//        transferService = (TransferService)proxyFactory.getProxy(transferService);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

            ConnectionUtils ConnectionUtils = (ConnectionUtils)webApplicationContext.getBean("connectionUtils");
            System.out.println(System.identityHashCode(ConnectionUtils));
//            transferService.transfer("1","2",25);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
