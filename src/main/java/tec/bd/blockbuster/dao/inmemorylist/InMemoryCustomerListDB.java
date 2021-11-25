package tec.bd.blockbuster.dao.inmemorylist;

import tec.bd.blockbuster.dao.CustomerDAO;
import tec.bd.blockbuster.entity.Customer;

import java.util.List;
import java.util.Optional;

public class InMemoryCustomerListDB implements CustomerDAO {

    @Override
    public Optional<Customer> findByCed(long cedula) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAllCustomers() { return null; }

    @Override
    public Optional<Customer> findByCedCustomer(long customerCed) { return Optional.empty(); }

    @Override
    public Optional<Customer> findByNameCustomer(String name) {
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {   }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {   }

    @Override
    public void delete(Customer customer) {   }

    @Override
    public void update(Customer customer) {   }

    @Override
    public void delete(Long aLong) {   }

    @Override
    public void updateCustomer(long cedula, String nombre, String apellido, String direccion, String telefono) {   }

    @Override
    public void deleteCustomer(long customerId) {    }
}