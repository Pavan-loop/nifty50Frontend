package com.nichi.nifty50frontend.database.dao;

import com.nichi.nifty50frontend.database.model.TradeList;
import com.nichi.nifty50frontend.database.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TradeEntryDAO {

    public void saveAll(List<TradeList> tradeLists) {
        Transaction transaction = null;

        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (TradeList trade : tradeLists) {
                session.merge(trade);
            }

            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e.getMessage());
        }
    }
}
