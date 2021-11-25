package tec.bd.blockbuster.dao;

import tec.bd.blockbuster.entity.Category;

import java.util.Optional;

public interface CategoryDAO extends GenericDAO<Category, Long> {

    Optional<Category> findByName(String name);

    void save(long id, String name);

    void update(long id, String nombre);
}