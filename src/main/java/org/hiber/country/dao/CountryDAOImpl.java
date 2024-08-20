package org.hiber.country.dao;

import org.hiber.country.entity.Country;
import org.hiber.country.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CountryDAOImpl implements CountryDAO {
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    @Override
    public void save(Country city) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(city);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Country findById(int id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Country.class, id);
        }
    }

    @Override
    public void update(Country city) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(city);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Country city) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.delete(city);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> findAll(int page, int size) {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Country", Country.class).setFirstResult((page -1) * page).setMaxResults(size).list();
        }
    }
}
