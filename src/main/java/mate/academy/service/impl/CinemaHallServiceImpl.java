package mate.academy.service.impl;

import java.util.List;
import mate.academy.dao.CinemaHallDao;
import mate.academy.model.CinemaHall;
import mate.academy.service.CinemaHallService;

public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallDao cinemaHallDao;

    public CinemaHallServiceImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallDao.addCinemaHall(cinemaHall);
    }

    @Override
    public CinemaHall getCinemaHall(Long id) {
        return cinemaHallDao.getCinemaHall(id);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
