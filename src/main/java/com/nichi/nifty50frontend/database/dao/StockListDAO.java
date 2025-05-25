package com.nichi.nifty50frontend.database.dao;

import com.nichi.nifty50frontend.database.model.StocksList;
import com.nichi.nifty50frontend.database.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StockListDAO {
    public List<StocksList> getAllStockList() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<StocksList> stocksLists = null;
        try {
            Query<StocksList> query = session.createQuery("FROM StocksList", StocksList.class);
            stocksLists = query.list();
            System.out.println("illi banthu");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exception");
        }finally {
            session.close();
            System.out.println("finally");
        }
        return stocksLists;
    }
}