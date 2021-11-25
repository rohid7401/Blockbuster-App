package tec.bd.blockbuster.dao.mysql;


import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.entity.Category;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class CategoryDAOImpl extends GenericMySqlDAOImpl<Category, Long> implements CategoryDAO {

    private static final String SQL_FIND_ALL_CATEGORIES = "select id, nombre from categoria";
    private static final String SQL_FIND_BY_ID_CATEGORY = "select id, nombre from categoria where id = ?";
    private static final String SQL_FIND_BY_NAME = "select id, nombre from categoria where nombre = ?";
    private static final String SQL_INSERT_CATEGORY = "insert into categoria(id, nombre) values (?, ?)";

    private static final String PROC_CREATE_CATEGORY = "{call createCategory(?, ?)}";
    private static final String PROC_READ_CATEGORY = "{call readCategory(?)}";
    private static final String PROC_UPDATE_CATEGORY = "{call updateCategory(?, ?)}";
    private static final String PROC_DELETE_CATEGORY = "{call deleteCategory(?)}";

    private final DataSource dataSource;

    public CategoryDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            var stmt = dbConnection.prepareStatement(SQL_FIND_ALL_CATEGORIES);
            var resultSet = stmt.executeQuery();
            return resultSetToList(resultSet);
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return categories;
    }

    @Override
    public Optional<Category> findById(Long categoryId) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            var stmt = dbConnection.prepareStatement(PROC_READ_CATEGORY);
            stmt.setInt(1, 1);
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return Optional.of(resultSetToEntity(resultSet));
            }
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Category> findByName(String name) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            var stmt = dbConnection.prepareStatement(SQL_FIND_BY_NAME);
            stmt.setString(1, name );
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return Optional.of(resultSetToEntity(resultSet));
            }
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(Category category) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            PreparedStatement insertCategory = dbConnection.prepareStatement(PROC_CREATE_CATEGORY);
            insertCategory.setLong(1, category.getId());
            insertCategory.setString(2, category.getNombre());
            insertCategory.executeUpdate();
        } catch (Exception e) {
            try {
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
    }

    @Override
    public void delete(Long categoryId) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            CallableStatement stmt = dbConnection.prepareCall(PROC_DELETE_CATEGORY);
            stmt.setLong(1, categoryId);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't delete category id " + categoryId, e);

        }
    }

    @Override
    public void update(long id, String nombre) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            CallableStatement stmt = dbConnection.prepareCall(PROC_UPDATE_CATEGORY);
            stmt.setLong(1, id);
            stmt.setString(2, nombre);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't update category id " + id, e);

        }
    }

    @Override
    protected Category resultSetToEntity(ResultSet resultSet) throws SQLException {
        var categoryId = resultSet.getInt("id");
        var name = resultSet.getString("nombre");
        var category = new Category(categoryId, name);
        return category;
    }

    @Override
    protected List<Category> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while(resultSet.next()) {
            categories.add(resultSetToEntity(resultSet));
        }
        return categories;
    }
}