package org.hiber.country.dao;

import org.hiber.country.entity.City;
import org.hiber.country.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public void save(City city) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()){
            tx = session.beginTransaction();
            session.save(city);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public City findById(int id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public void update(City city) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()){
            tx = session.beginTransaction();
            session.update(city);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(City city) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()){
            tx = session.beginTransaction();
            session.delete(city);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<City> findAll(int page, int size) {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from City ", City.class).setFirstResult((page - 1) * size).setMaxResults(size).list();
        }
    }

    public int getTotalCount() {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction(); // Начинаем транзакцию

            Query<Long> query = session.createQuery("select count(c) from City c", Long.class);
            int totalCount = Math.toIntExact(query.uniqueResult());

            transaction.commit(); // Завершаем транзакцию
            return totalCount;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Откатываем транзакцию в случае ошибки
            }
            throw e;
        }
    }
}
