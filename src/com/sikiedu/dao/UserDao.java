package com.sikiedu.dao;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UserDao {

    public void addUser(User user){
      //得到配置信息
      Configuration config = new Configuration().configure();
       //创建sessionFactory对象
        SessionFactory sessionFactory =config.buildSessionFactory();
        //获取session
       Session session =sessionFactory.openSession();
       //打开session
        Transaction transaction = session.beginTransaction();
        //存储user对象
        session.save(user);
        //提交事务
        transaction.commit();
        //关闭资源
        session.close();

    }

    public void deleteUser(){
     Configuration config = new Configuration().configure();
     SessionFactory factory = config.buildSessionFactory();
     Session session = factory.openSession();
     //开启事务
     Transaction transaction = session.beginTransaction();
     //得到id为0dba5eb1-71e0-42c7-8a82-4a5b3f59f0c4的对象
     User user = session.get(User.class,"0dba5eb1-71e0-42c7-8a82-4a5b3f59f0c4");
     session.delete(user);
     transaction.commit();
     session.close();
    }

    public void ChangeUser()
    {  Session session = HibernateUtils.getSession();
        //开启事务
        Transaction beginTransaction = session.beginTransaction();
        //获得id为fe1fbbc7-e474-41d9-a7ee-b6e4bd634e91的对象
        User user=session.get(User.class,"fe1fbbc7-e474-41d9-a7ee-b6e4bd634e91");
        //将该对象改名,更新数据库
        user.setUsername("trigger");
        session.update(user);
        //提交事务
        beginTransaction.commit();
        session.close();
    }

    public void findUser()
    { Configuration config = new Configuration().configure();
      SessionFactory factory =config.buildSessionFactory();
      Session openSession = factory.openSession();
      Transaction beginTransaction = openSession.beginTransaction();
      User user=openSession.get(User.class,"fe1fbbc7-e474-41d9-a7ee-b6e4bd634e91");
      System.out.println(user.getUsername());
      beginTransaction.commit();
      openSession.close();

    }

    public User findUserById(String id) {
        Session session = HibernateUtils.getCurrentSession();
        return  session.get(User.class,id);
    }

    public void ChangeUserByUserId(String id) {
        Session session=HibernateUtils.getCurrentSession();
        //先持久化user
        User user = session.get(User.class,id);
        //改变user(持久化->beginTransaction.commit(),他才会同步到数据库)
        user.setUsername("lain");
    }
}
