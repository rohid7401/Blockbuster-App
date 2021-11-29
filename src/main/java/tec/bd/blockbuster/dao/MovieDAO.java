package tec.bd.blockbuster.dao;

import tec.bd.blockbuster.entity.Movie;

import java.util.Date;
import java.util.Optional;

public interface MovieDAO extends GenericDAO<Movie, Long> {

    Optional<Movie> findByTitle(String title);

    void update(long id, String titulo, Date fecha_lanzamiento, Long categoria);
}