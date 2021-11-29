package tec.bd.blockbuster;

import tec.bd.blockbuster.dao.*;
import tec.bd.blockbuster.entity.*;

import java.util.List;
import java.util.Date;

public class Blockbuster {

    private MovieDAO movieDAO;
    private CustomerDAO customerDAO;
    private CategoryDAO categoryDAO;
    private LoanDAO loanDAO;

    public Blockbuster(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
    public Blockbuster(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public Blockbuster(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    public Blockbuster(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    // Get All ----------------------
    public List<Movie> getAllMovies() { return this.movieDAO.findAll(); }

    public List<Customer> getAllCustomers() {
        return this.customerDAO.findAll();
    }

    public List<Category> getAllCategories() {
        return this.categoryDAO.findAll();
    }

    public List<Loan> getAllLoan() {
        return this.loanDAO.findAll();
    }

    // ADD ----------------------
    public void addMovie(Movie movie) {
        this.movieDAO.save(movie);
    }

    public void addCustomer(Customer customer) {
        this.customerDAO.save(customer);
    }

    public void addCategory(Category category) {
        this.categoryDAO.save(category);
    }

    public void addLoan(Loan loan) {
        this.loanDAO.save(loan);
    }

    // GET ----------------------
    public Movie getMovie(String movieName) {
        return this.movieDAO.findByTitle(movieName).orElse(null);
    }

    public Movie getMovie(long movieId) {
        return this.movieDAO.findById(movieId).orElse(null);
    }

    public Customer getCustomer(long cedula) {
        return this.customerDAO.findByCed(cedula).orElse(null);
    }

    public Category getCategory(long id) {
        return this.categoryDAO.findById(id).orElse(null);
    }

    public Loan getLoan(long cedula, long codigo) {
        return this.loanDAO.findLoan(cedula, codigo).orElse(null);
    }

    // EDIT ----------------------
    public void editMovieTitle(String currentMovieName, String newMovieName) {
        var movie = this.getMovie(currentMovieName);
        movie.setTitle(newMovieName);
    }

    public void editCustomer(long ced, String direccion, String telefono) {
        var customer = this.getCustomer(ced);
        customer.setAddress(direccion);
        customer.setNumber(telefono);
    }

    public void editCategory(long id, String categoryName) {
        var category = this.getCategory(id);
        category.setNombre(categoryName);
    }

    public void editLoan(long ced, long cod, String estado, Date fecha_devolucion) {
        var loan = this.getLoan(ced, cod);
        loan.setEstado(estado);
        loan.setFechaDevolucion(fecha_devolucion);
    }

    // REMOVE ----------------------
    public void removeMovie(long movieId) { this.movieDAO.delete(movieId); }

    public void removeCustomer(long customerId) {
        this.customerDAO.delete(customerId);
    }

    public void removeCategory(long categoryId) {
        this.categoryDAO.delete(categoryId);
    }

    public void removeLoan(long loanId, long loanCod) {
        this.loanDAO.delete(loanId, loanCod);
    }

}