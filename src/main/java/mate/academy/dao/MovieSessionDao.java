package mate.academy.dao;

import java.time.LocalDate;
import java.util.List;
import mate.academy.model.MovieSession;

public interface MovieSessionDao {
    MovieSessionDao add(MovieSessionDao movieSession);

    MovieSessionDao get(Long id);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

}
