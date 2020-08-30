package com.sikiedu.dao;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class SQLDao {
    //基本查询
    public void fun()
    {
        Session session=HibernateUtils.getSession();
        Transaction beginTransaction = session.beginTransaction();
        String sql="select * from user";
        //创建sql查询对象
        NativeQuery query = session.createSQLQuery(sql);
        query.addEntity(User.class);
        List<User> list = query.list();
        System.out.println(list.get(0).getUsername()+"---"+list.get(1).getUsername()+"---"+list.get(2).getUsername());

        beginTransaction.commit();
        session.close();
    }
    //条件查询
    public void fun1()
    {
        Session session=HibernateUtils.getSession();
        Transaction beginTransaction = session.beginTransaction();
        String sql="select * from user where id= ?";
        //创建sql查询对象
        NativeQuery query = session.createSQLQuery(sql);
        query.setParameter(1,"3");
        query.addEntity(User.class);
        User user = (User)query.uniqueResult();
        System.out.println(user);

        beginTransaction.commit();
        session.close();
    }
    //分页查询
    public void fun2()
    {
        Session session=HibernateUtils.getSession();
        Transaction beginTransaction = session.beginTransaction();
        String sql="select * from user  limit ? , ?";
        //创建sql查询对象
        NativeQuery query = session.createSQLQuery(sql);
        query.setParameter(1,0);
        query.setParameter(2,2);
        query.addEntity(User.class);
        List<User> list = query.list();
        System.out.println(list+"---"+list.get(0).getUsername()+"---"+list.get(1).getUsername());

        beginTransaction.commit();
        session.close();
    }







}
