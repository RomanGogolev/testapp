package org.student.testapp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.student.testapp.models.User;
import org.student.testapp.services.HibernateUtil;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserManager {

    public static User getUser(String username) {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from User user where lower(user.username) like lower(:username)");
        query.setParameter("username",username);
        List<User> list = query.list();
        session.getTransaction().commit();
        return list.get(0);
    }

    public static void create(User user){
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public static boolean used(String username){
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from User user where lower(user.username) like lower(:username)");
        query.setParameter("username",username);
        List<User> users = query.list();
        session.getTransaction().commit();
        if(users.size()>0){
            return true;
        }else return false;
    }

}
