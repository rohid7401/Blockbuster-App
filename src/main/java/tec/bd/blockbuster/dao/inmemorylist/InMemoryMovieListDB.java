package tec.bd.blockbuster.dao.inmemorylist;

import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.entity.Movie;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class InMemoryMovieListDB implements MovieDAO {


    @Override
    public Optional<Movie> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Movie movie) {    }

    @Override
    public void update(Movie movie) {   }

    @Override
    public void update(long id, String titulo, Date fecha_lanzamiento, Long categoria) {   }

    @Override
    public void delete(Long aLong) {    }
}