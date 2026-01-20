package mate.academy.dao;

import java.util.List;
import mate.academy.model.CinemaHall;

public interface CinemaHallDao {
    CinemaHall addCinemaHall(CinemaHall cinemaHall);

    CinemaHall getCinemaHall(Long id);

    List<CinemaHall> getAll();
}
