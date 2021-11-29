package tec.bd.blockbuster;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import tec.bd.blockbuster.dao.*;
import tec.bd.blockbuster.dao.inmemorylist.*;
import tec.bd.blockbuster.dao.mysql.*;
import tec.bd.blockbuster.entity.*;


import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ApplicationContext {

    private Blockbuster blockbuster;

    public ApplicationContext() {

        var hikariDataSource = initHikariDataSource();
        var mysqlMovies = initMysqlMovieDAO(hikariDataSource);
        var listMovies = initInMemoryListMovieDAO();
        var mysqlCategories = initMysqlCategoryDAO(hikariDataSource);
        var listCategories = initInMemoryListCategoryDAO();
        var mysqlCustomers = initMysqlCustomerDAO(hikariDataSource);
        var listCustomers = initInMemoryListCustomerDAO();
        var mysqlLoans = initMysqlLoanDAO(hikariDataSource);
        var listLoans = initInMemoryListLoanDAO();

        this.blockbuster = initBlockbuster(mysqlMovies);
        this.blockbuster = initBlockbuster(mysqlCustomers);
        this.blockbuster = initBlockbuster(mysqlLoans);
        this.blockbuster = initBlockbuster(mysqlCategories);
    }

    private static HikariDataSource initHikariDataSource() {
        HikariConfig config = new HikariConfig("/database.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    public static MovieDAO initMysqlMovieDAO(DataSource dataSource) {
        return new MovieDAOImpl(dataSource) {
            @Override
            public void update(Movie movie) { }
        };
    }

    public static CategoryDAO initMysqlCategoryDAO(DataSource dataSource) {
        return new CategoryDAOImpl(dataSource) {
            @Override
            public void update(Category category) { }

            @Override
            public void save(long id, String name) { }
        };
    }

    public static CustomerDAO initMysqlCustomerDAO(DataSource dataSource) {
        return new CustomerDAOImpl(dataSource) {

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
            public Optional<Customer> findByCed(long cedula) {
                return Optional.empty();
            }

        };
    }

    public static LoanDAO initMysqlLoanDAO(DataSource dataSource) {
        return new LoanDAOImpl(dataSource) {

            @Override
            public Optional<Loan> findLoan(long cedula, long codigo) {
                return Optional.empty();
            }

            @Override
            public void save(long cedula, long codigo) { }

            @Override
            public void delete(long cedula, long codigo) { }

            @Override
            public List<Loan> findAll() {
                return null;
            }

            @Override
            public Optional<Loan> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public void save(Loan loan) { }

            @Override
            public void update(Loan loan) { }

            @Override
            public void delete(Long aLong) { }
        };
    }

    public static MovieDAO initInMemoryListMovieDAO() {
        return new InMemoryMovieListDB();
    }

    public static CategoryDAO initInMemoryListCategoryDAO() {
        return new InMemoryCategoryListDB();
    }

    public static CustomerDAO initInMemoryListCustomerDAO() {
        return new InMemoryCustomerListDB();
    }

    public static LoanDAO initInMemoryListLoanDAO() {
        return new InMemoryLoanListDB();
    }

    public static Blockbuster initBlockbuster(MovieDAO movieDAO) {
        return new Blockbuster(movieDAO);
    }

    public static Blockbuster initBlockbuster(CategoryDAO categoryDAO) {
        return new Blockbuster(categoryDAO);
    }

    public static Blockbuster initBlockbuster(CustomerDAO customerDAO) {
        return new Blockbuster(customerDAO);
    }

    public static Blockbuster initBlockbuster(LoanDAO loanDAO) {
        return new Blockbuster(loanDAO);
    }

    public Blockbuster getBlockbuster() {
        return blockbuster;
    }
}