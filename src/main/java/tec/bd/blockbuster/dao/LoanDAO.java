package tec.bd.blockbuster.dao;

import tec.bd.blockbuster.entity.Loan;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LoanDAO extends GenericDAO<Loan, Long> {

    Optional<Loan> findLoan(long cedula, long codigo);

    void save(long cedula, long codigo);

    void delete(long cedula, long codigo);

    List<Loan> findAllLoan();

    Optional<Loan> findByCedLoan(Long loanCed);

    Optional<Loan> findByCodLoan(Long codigo);

    void saveLoan(Loan loan);

    void deleteLoan(Long cedula, long codigo);

    void updateLoan(long cedula, long codigo, String estado, Date fecha_devolucion);
}