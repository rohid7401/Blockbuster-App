package tec.bd.blockbuster.dao.inmemorylist;

import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.entity.Category;

import java.util.List;
import java.util.Optional;

public class InMemoryCategoryListDB implements CategoryDAO {


    @Override
    public Optional<Category> findByName(String name) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Category category) {    }

    @Override
    public void save(long id, String name) {    }

    @Override
    public void update(Category category) {   }

    @Override
    public void update(long id, String name) {   }

    @Override
    public void delete(Long aLong) {    }
}