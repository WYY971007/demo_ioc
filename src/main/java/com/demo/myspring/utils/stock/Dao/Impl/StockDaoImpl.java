//package com.demo.myspring.utils.stock.Dao.Impl;
//
//import com.demo.myspring.utils.ConnectionUtils;
//import com.demo.myspring.utils.stock.Dao.StockDao;
//import com.demo.myspring.utils.stock.entity.Stock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//
//@Component("stockDao")
//public class StockDaoImpl implements StockDao {
//
//
////    @Override
////    public List<Stock> queryStock(Map<String, String> stock) throws SQLException {
////        return null;
////    }
//
//    @Autowired
//    private ConnectionUtils connectionUtils;
//
//    public List<Stock> queryStock(Map<String,String> stock) throws SQLException {
//
//        Connection conn = connectionUtils.getCurrentThreadConn();
//
//        Set<String> keys = stock.keySet();
//
//        String where = "SELECT * FROM stock WHERE";
//
//
//        int i = 0;
//        for (String s: keys) {
//            if (i == 0) {
//                if (stock.get(s).contains("%")) {
//                    where = where + " " + s + " like " + "'"+ stock.get(s) +"'";
//                } else {
//                    where = where + " " + s + " = " + "'"+ stock.get(s) +"'";
//                }
//            } else {
//                if (stock.get(s).contains("%")) {
//                    where = where + " and " + s + " like " + "'"+ stock.get(s) +"'";
//                } else {
//                    where = where + " and " + s + " = " + "'"+ stock.get(s) +"'";
//                }
//            }
//
//            i = i +1;
//        }
//        PreparedStatement ps = conn.prepareStatement(where);
//
//        ResultSet result = ps.executeQuery();
//
//        List<Stock> stock1 = new ArrayList<>();
//        while (result.next()) {
//            Stock s = new Stock();
//            s.setCode(result.getString("code"));
//            s.setCategory(result.getString("category"));
//            s.setMarket(result.getString("market"));
//            s.setName(result.getString("name"));
//            s.setPinyin(result.getString("pinyin"));
//            stock1.add(s);
//        }
//
//        result.close();
//        ps.close();
//
//        return stock1;
//    }
//}
