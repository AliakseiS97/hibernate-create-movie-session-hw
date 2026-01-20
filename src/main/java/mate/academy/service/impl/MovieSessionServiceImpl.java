package mate.academy.service.impl;

import java.time.LocalDate;
import java.util.List;
import mate.academy.dao.MovieSessionDao;
import mate.academy.model.MovieSession;
import mate.academy.service.MovieSessionService;

public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public MovieSessionDao add(MovieSessionDao movieSession) {
        return movieSessionDao.add(movieSession);
    }

    @Override
    public MovieSessionDao get(Long id) {
        return movieSessionDao.get(id);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }
}
