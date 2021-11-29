package tec.bd.blockbuster.dao;

import tec.bd.blockbuster.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO extends GenericDAO<Customer, Long> {

    Optional<Customer> findByCed(long cedula);

    List<Customer> findAllCustomers();

    Optional<Customer> findByCedCustomer(long customerCed);

    Optional<Customer> findByNameCustomer(String name);

    void saveCustomer(Customer customer);

    void deleteCustomer(long customerId);

    void delete(Customer customer);

    void updateCustomer(long id, String nombre, String apellido, String direccion, String telefono);
}