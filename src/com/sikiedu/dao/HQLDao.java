package com.sikiedu.dao;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HQLDao {
    //HQL中,不能出现表的任何内容
    //基本查询
    public void search(){
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        //操作 select * from user
        String hql ="from com.sikiedu.domain.User";

        Query query = session.createQuery(hql);
        List<User> list=query.list();          //查询多条数据
        User user =(User)query.uniqueResult(); //查询唯一数据
        System.out.println(list);
        beginTransaction.commit();
        session.close();
    }

    //条件查询
    public void search1(){
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        //操作 select * from user where id='1'"
        String hql ="from com.sikiedu.domain.User where id='1'";

        Query query = session.createQuery(hql);
        User result = (User)query.uniqueResult();          //查询多条数据
        System.out.println(result.getUsername());
        beginTransaction.commit();
        session.close();
    }
    //条件查询
    public void search2(String id){
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        //操作 select * from user where id='1'"
        String hql ="from com.sikiedu.domain.User where id= ?0";
        Query query = session.createQuery(hql);
        query.setParameter(0,id);
        User user =(User)query.uniqueResult();
        System.out.println(user.getPassword());
        beginTransaction.commit();
        session.close();
    }

    //命名占位符查询
    public void search3(String id){
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        //操作 select * from user where id='1'"
        String hql ="from com.sikiedu.domain.User where id= :id";
        Query query = session.createQuery(hql);
        //query.setParameter(0,id);
        query.setParameter("id",id);
        User user =(User)query.uniqueResult();
        System.out.println(user.getEmail());
        beginTransaction.commit();
        session.close();
    }
    //分页查询limit ? , ?
    public void search4(){
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        //操作 select * from user where id='1'"
        String hql ="from com.sikiedu.domain.User";
        Query query = session.createQuery(hql);

        query.setFirstResult(0);
        query.setMaxResults(1);
        List<User> list=query.list();

        System.out.println(list.get(0).getUsername());
        beginTransaction.commit();
        session.close();
    }











}
