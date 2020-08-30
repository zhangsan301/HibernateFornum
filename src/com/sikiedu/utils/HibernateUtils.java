package com.sikiedu.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory=null;

    static{
        Configuration config = new Configuration().configure();
        //获取sessionFactory工厂
        sessionFactory = config.buildSessionFactory();
     }

      //获得全新的session
      public static Session getSession(){

        Session session = sessionFactory.openSession();
        return session;
      }

      public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
      }
}
