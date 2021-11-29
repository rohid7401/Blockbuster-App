package tec.bd.blockbuster.entity;

import java.util.Date;

public class Loan {

    private long cedula;
    private long codigo;
    private String estado;
    private Date fecha_prestamo;
    private Date fecha_devolucion;

    public Loan(long cedula, long codigo, String estado, Date fecha_prestamo, Date fecha_devolucion) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.estado = estado;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public long getCedula() { return cedula; }

    public void setCedula(long cedula) { this.cedula = cedula; }

    public long getCodigo() { return codigo; }

    public void setCodigo(long codigo) { this.codigo = codigo; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public Date getFechaPrestamo() { return fecha_prestamo; }

    public void setFechaPrestamo(Date fecha_prestamo) { this.fecha_prestamo = fecha_prestamo; }

    public Date getFechaDevolucion() { return fecha_devolucion; }

    public void setFechaDevolucion(Date fecha_devolucion) { this.fecha_devolucion = fecha_devolucion; }

}
