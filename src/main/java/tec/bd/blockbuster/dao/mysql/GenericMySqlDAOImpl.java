package tec.bd.blockbuster.dao.mysql;

import tec.bd.blockbuster.dao.GenericDAO;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericMySqlDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected abstract T resultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract List<T> resultSetToList(ResultSet resultSet) throws SQLException;

}