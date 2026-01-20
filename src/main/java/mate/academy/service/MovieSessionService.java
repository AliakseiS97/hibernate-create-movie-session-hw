package mate.academy.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.dao.MovieSessionDao;
import mate.academy.model.MovieSession;

public interface MovieSessionService {
    MovieSessionDao add(MovieSessionDao movieSession);

    MovieSessionDao get(Long id);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}
