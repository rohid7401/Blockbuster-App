package tec.bd.blockbuster.entity;

public class Customer {

    private long cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Customer(long cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Customer(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Customer(long cedula, String nombre, String apellido, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getCustomer() {
        return cedula;
    }

    public void setCustomer(long id) {
        this.cedula = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getLastName() {
        return apellido;
    }

    public void setLastName(String lastName) {
        this.apellido = lastName;
    }

    public String getAddress() {
        return direccion;
    }

    public void setAddress(String Address) {
        this.direccion = Address;
    }

    public String getNumber() {
        return telefono;
    }

    public void setNumber(String number) {
        this.telefono = number;
    }
}

