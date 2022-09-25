package domain;

public class Persona {// Esta es una clase de entidad o de dominio, debido a que tiene una
                      // representacion en la base de datos. A la clase que interactua con la base de
                      // datos se le conococe como DAO (Data Access Object)
    private int idPersona;
    private String nombre;
    private String apeliido;
    private String email;
    private String telefono;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apeliido, String email, String telefono) {
        this.nombre = nombre;
        this.apeliido = apeliido;
        this.email = email;
        this.telefono = telefono;
    }

    public Persona(int idPersona, String nombre, String apeliido, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apeliido = apeliido;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido() {
        return apeliido;
    }

    public void setApeliido(String apeliido) {
        this.apeliido = apeliido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apeliido=" + apeliido + ", email=" + email
                + ", telefono=" + telefono + "]";
    }

}
