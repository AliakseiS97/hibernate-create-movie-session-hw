package mate.academy.dao.impl;

import jakarta.persistence.Query;
import java.util.List;
import mate.academy.dao.CinemaHallDao;
import mate.academy.exception.DataProcessingException;
import mate.academy.model.CinemaHall;
import mate.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CinemaHallDaoImpl implements CinemaHallDao {
    @Override
    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cinemaHall);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Cannot add CinemaHall", e);
        }
        return cinemaHall;
    }

    @Override
    public CinemaHall getCinemaHall(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CinemaHall cinemaHall = session.get(CinemaHall.class, id);
            return cinemaHall;
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get CinemaHall", e);
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from CinemaHall", CinemaHall.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get All CinemaHalls", e);
        }
    }
}
