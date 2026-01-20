package mate.academy.dao.impl;

import jakarta.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import mate.academy.dao.MovieSessionDao;
import mate.academy.exception.DataProcessingException;
import mate.academy.model.MovieSession;
import mate.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public MovieSessionDao add(MovieSessionDao movieSession) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(movieSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Cannot save MovieSession", e);
        }
        return movieSession;
    }

    @Override
    public MovieSessionDao get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            MovieSessionDao movieSession = session.get(MovieSessionDao.class, id);
            return movieSession;
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get MovieSession by id " + id, e);
        }
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM MovieSession ms "
                            + "WHERE ms.movie.id = :movieId"
                            + "AND ms.localDateTime BETWEEN :start AND :end",
                    MovieSessionDao.class);
            query.setParameter("movieId", movieId);
            query.setParameter("start", startOfDay);
            query.setParameter("end", endOfDay);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get MovieSessionDao", e);
        }
    }
}
