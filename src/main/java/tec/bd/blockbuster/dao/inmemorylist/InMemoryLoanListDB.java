package tec.bd.blockbuster.dao.inmemorylist;

import tec.bd.blockbuster.dao.LoanDAO;
import tec.bd.blockbuster.entity.Loan;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class InMemoryLoanListDB implements LoanDAO {

    @Override
    public List<Loan> findAll() {
        return null;
    }

    @Override
    public Optional<Loan> findById(Long aLong) { return Optional.empty(); }

    @Override
    public void save(Loan movie) {    }

    @Override
    public void update(Loan movie) {   }

    @Override
    public void delete(Long aLong) {    }

    @Override
    public Optional<Loan> findLoan(long cedula, long codigo) {
        return Optional.empty();
    }

    @Override
    public void save(long cedula, long codigo) {   }

    @Override
    public void delete(long cedula, long codigo) {   }

    @Override
    public List<Loan> findAllLoan() {
        return null;
    }

    @Override
    public Optional<Loan> findByCedLoan(Long loanCed) {
        return Optional.empty();
    }

    @Override
    public Optional<Loan> findByCodLoan(Long codigo) {
        return Optional.empty();
    }

    @Override
    public void saveLoan(Loan loan) {   }

    @Override
    public void deleteLoan(Long cedula, long codigo) {   }

    @Override
    public void updateLoan(long cedula, long codigo, String estado, Date fecha_devolucion) {    }
}