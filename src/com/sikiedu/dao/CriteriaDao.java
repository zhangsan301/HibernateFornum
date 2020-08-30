package com.sikiedu.dao;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaDao {

    //Criteria的基本查询
    public void search() {
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> createQuery=criteriaBuilder.createQuery(User.class);
        Root<User> from = createQuery.from(User.class);
        createQuery.select(from);
        List<User> resultList=session.createQuery(createQuery).getResultList();
        System.out.println(resultList);

        beginTransaction.commit();
        session.close();
    }

    //Criteria的条件查询
    public void search1() {
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> createQuery=criteriaBuilder.createQuery(User.class);
        Root<User> root = createQuery.from(User.class);
        createQuery.select(root).where(root.get("id").in("1"));
        List<User> resultList=session.createQuery(createQuery).getResultList();
        System.out.println(resultList);

        beginTransaction.commit();
        session.close();
    }

    //Criteria查询总数
    public void search2() {
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteria=criteriaBuilder.createQuery(Long.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(criteriaBuilder.count(root));
        Long count=session.createQuery(criteria).uniqueResult();
        System.out.println(count);

        beginTransaction.commit();
        session.close();
    }
    //查询名字带有i的人的总数
    public void search3() {
        Session session = HibernateUtils.getSession();
        Transaction beginTransaction=session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteria=criteriaBuilder.createQuery(Long.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(criteriaBuilder.count(root)).where(criteriaBuilder.like(root.get("username"),"%i%"));
        Long count=session.createQuery(criteria).uniqueResult();
        System.out.println(count);

        beginTransaction.commit();
        session.close();
    }




















}
