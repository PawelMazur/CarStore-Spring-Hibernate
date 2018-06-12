/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.dao;

import com.carstore.pojo.Faktura;
import com.carstore.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Pawel
 */
public class FakturaDao {
    public static List<Faktura> layDS(){
        
        List<Faktura> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Faktura";
            Query query = session.createQuery(hql);
            lst = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
        
    }
    
    public static List getFaktura() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Faktura> filmList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Faktura");
            filmList = (List<Faktura>) q.list();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }
}
