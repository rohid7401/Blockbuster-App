package tec.bd.blockbuster.dao.mysql;


import tec.bd.blockbuster.Conexion;
import tec.bd.blockbuster.dao.CustomerDAO;
import tec.bd.blockbuster.entity.Customer;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CustomerDAOImpl extends GenericMySqlDAOImpl<Customer, Long> implements CustomerDAO {

    private static final String SQL_FIND_ALL_CUSTOMERS = "select cedula, nombre, apellido, dirrecion, telefono from customer";
    private static final String SQL_FIND_BY_CED_CUSTOMER = "select cedula, nombre, apellido, dirrecion, telefono from customer where cedula = ?";
    private static final String SQL_FIND_BY_NAME = "select cedula, nombre, apellido, dirrecion, telefono from customer where nombre = ?";
    private static final String SQL_INSERT_CUSTOMER = "insert into customer(cedula, nombre, apellido, dirrecion, telefono) values (?, ?, ?, ?, ?)";
    private static final String PROC_UPDATE_CUSTOMER = "update customer set cedula = ?, nombre = ?, apellido = ?, dirrecion = ?, telefono = ? where cedula = ?";
    private static final String PROC_DELETE_CUSTOMER = "delete from cliente where cedula = ?";

    private final DataSource dataSource;

    public CustomerDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            var stmt = dbConnection.prepareStatement(SQL_FIND_ALL_CUSTOMERS);
            var resultSet = stmt.executeQuery();
            stmt.close();
            return resultSetToList(resultSet);
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return customers;
    }

    @Override
    public Optional<Customer> findByCedCustomer(long customerCed) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            var stmt = con.prepareStatement(SQL_FIND_BY_CED_CUSTOMER);
            stmt.setLong(1, 1);
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return Optional.of(resultSetToEntity(resultSet));
            }
            stmt.close();
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                con.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findByNameCustomer(String name) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            var stmt = con.prepareStatement(SQL_FIND_BY_NAME);
            stmt.setString(1, name );
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return Optional.of(resultSetToEntity(resultSet));
            }
            stmt.close();
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                con.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return Optional.empty();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            PreparedStatement insertCategory = con.prepareStatement(SQL_INSERT_CUSTOMER);
            insertCategory.setLong(1, customer.getCustomer());
            insertCategory.setString(2, customer.getName());
            insertCategory.setString(3, customer.getLastName());
            insertCategory.setString(4, customer.getAddress());
            insertCategory.setString(5, customer.getNumber());
            insertCategory.executeUpdate();
            insertCategory.close();
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
    }

    @Override
    public void deleteCustomer(long customerId) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            CallableStatement stmt = con.prepareCall(PROC_DELETE_CUSTOMER);
            stmt.setLong(1, customerId);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't delete customer id " + customerId, e);

        }
    }

    @Override
    public void updateCustomer(long id, String nombre, String apellido,String direccion, String telefono) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            CallableStatement stmt = con.prepareCall(PROC_UPDATE_CUSTOMER);
            stmt.setLong(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't update customer id " + id, e);
        }
    }

    @Override
    protected Customer resultSetToEntity(ResultSet resultSet) throws SQLException {
        var customerId = resultSet.getLong("cedula");
        var name = resultSet.getString("nombre");
        var apellido = resultSet.getString("apellido");
        var direccion = resultSet.getString("direccion");
        var telefono = resultSet.getString("telefono");
        var customer = new Customer(customerId, name, apellido, direccion, telefono);
        return customer;
    }

    @Override
    protected List<Customer> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        while(resultSet.next()) {
            customers.add(resultSetToEntity(resultSet));
        }
        return customers;
    }
}