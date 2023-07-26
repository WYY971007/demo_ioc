package com.demo.myspring.utils.stock.controller;

import com.demo.myspring.utils.DTOBuilder;
import com.demo.myspring.utils.stock.Service.StockService;
import com.demo.myspring.utils.stock.Service.StockTransService;
import com.demo.myspring.utils.stock.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import redis.clients.jedis.JedisPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/stock1")
public class StockServlet extends HttpServlet {



    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private StockService stockService;
    @Autowired
    private StockTransService stockTransService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        jedisPool = (JedisPool)webApplicationContext.getBean("jedisPool");
        stockService = (StockService)webApplicationContext.getBean("StockService");
        stockTransService = (StockTransService)webApplicationContext.getBean("StockTransService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {


            Map<String, String> data = new HashMap<>();
            Map<String, String[]> parameterMap = req.getParameterMap();
            Set<String> keyset = parameterMap.keySet();
            //获得键获取值
            for(String key:keyset){
                String [] values = parameterMap.get(key);
                System.out.println(key);
                for(String value:values) {
                    System.out.println(value);
                    value = value.replace("*","%");
                    data.put(key,value);
                }
                System.out.println("-------------");
            }

        List<Stock> stock = stockService.selectStock(data);
        stockTransService.transfer("1","2",10);



//           Jedis jedis = jedisPool.getResource();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
