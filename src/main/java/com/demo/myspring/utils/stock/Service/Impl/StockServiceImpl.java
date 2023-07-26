package com.demo.myspring.utils.stock.Service.Impl;
import com.demo.myspring.utils.stock.Dao.StockDao;
import com.demo.myspring.utils.stock.Service.StockService;
import com.demo.myspring.utils.stock.entity.Stock;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("StockService")
public class StockServiceImpl implements StockService {

    @Resource
    private StockDao stockDao;

    @Override
    public List<Stock> selectStock(Map<String, String> data) throws Exception {


        return stockDao.queryStock(data);
    }
}
