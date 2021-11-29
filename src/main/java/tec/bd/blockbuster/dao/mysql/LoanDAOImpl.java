package tec.bd.blockbuster.dao.mysql;


import tec.bd.blockbuster.Conexion;
import tec.bd.blockbuster.dao.LoanDAO;
import tec.bd.blockbuster.entity.Loan;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class LoanDAOImpl extends GenericMySqlDAOImpl<Loan, Long> implements LoanDAO {

    private static final String SQL_FIND_ALL_LOANS = "select cedula, codigo, estado, fecha_prestamo, fecha_devolucion from prestamo";
    private static final String SQL_FIND_BY_CED_LOAN= "select cedula, codigo, estado, fecha_prestamo, fecha_devolucion from prestamo where cedula = ?";
    private static final String SQL_FIND_BY_COD = "select cedula, codigo, estado, fecha_prestamo, fecha_devolucion from prestamo where codigo = ?";
    private static final String SQL_INSERT_LOAN = "insert into prestamo(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values (?, ?, ?, ?, ?)";

    private static final String PROC_CREATE_LOAN = "{call createLoan(?, ?, ?, ?, ?)}";
    private static final String PROC_READ_LOAN = "{call readLoan(?, ?)}";
    private static final String PROC_UPDATE_LOAN = "{call updateLoan(?, ?, ?, ?)}";
    private static final String PROC_DELETE_LOAN = "{call deleteLoan(?, ?)}";

    private DataSource dataSource;

    public LoanDAOImpl(DataSource dataSource) {
        super();
    }

    public void LoanDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Loan> findAllLoan() {
        List<Loan> categories = new ArrayList<>();
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            var stmt = con.prepareStatement(SQL_FIND_ALL_LOANS);
            var resultSet = stmt.executeQuery();
            return resultSetToList(resultSet);
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                con.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return categories;
    }

    @Override
    public Optional<Loan> findByCedLoan(Long cedula) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            var stmt = con.prepareStatement(SQL_FIND_BY_CED_LOAN);
            stmt.setLong(1,cedula);
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
    public Optional<Loan> findByCodLoan(Long codigo) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            var stmt = con.prepareStatement(SQL_FIND_BY_COD);
            stmt.setLong(1, codigo );
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
    public void saveLoan(Loan loan) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            PreparedStatement insertCategory = con.prepareStatement(PROC_CREATE_LOAN);
            insertCategory.setLong(1, loan.getCedula());
            insertCategory.setLong(2, loan.getCodigo());
            insertCategory.setString(3, loan.getEstado());
            insertCategory.setDate(4, (java.sql.Date) loan.getFechaPrestamo());
            insertCategory.setDate(5, (java.sql.Date) loan.getFechaDevolucion());
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
    public void deleteLoan(Long cedula, long codigo) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            CallableStatement stmt = con.prepareCall(PROC_DELETE_LOAN);
            stmt.setLong(1, cedula);
            stmt.setLong(2, codigo);
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't delete Loan ced " + cedula + ", cod: " + codigo, e);

        }
    }

    @Override
    public void updateLoan(long cedula, long codigo, String estado, Date fecha_devolucion) {
        Conexion dbcn = new Conexion();
        Connection con = dbcn.getConexion();
        try {
            CallableStatement stmt = con.prepareCall(PROC_UPDATE_LOAN);
            stmt.setLong(1, cedula);
            stmt.setLong(2, codigo);
            stmt.setString(3, estado);
            stmt.setDate(4, (java.sql.Date) fecha_devolucion);
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't update loan ced " + cedula + ", cod: " + codigo, e);

        }
    }

    @Override
    protected Loan resultSetToEntity(ResultSet resultSet) throws SQLException {
        var loanCed = resultSet.getLong("ced");
        var loanCod = resultSet.getLong("cod");
        var loanEst = resultSet.getString("est");
        var loanFP = resultSet.getDate("FP");
        var loanFD = resultSet.getDate("FD");

        var loan = new Loan(loanCed, loanCod, loanEst, loanFP, loanFD);
        return loan;
    }

    @Override
    protected List<Loan> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Loan> loans = new ArrayList<>();
        while(resultSet.next()) {
            loans.add(resultSetToEntity(resultSet));
        }
        return loans;
    }
}