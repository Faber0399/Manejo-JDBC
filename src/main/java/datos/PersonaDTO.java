package datos;

import java.sql.SQLException;
import java.util.List;

import domain.Persona;

public interface PersonaDTO {
    public List<Persona> seleccionar() throws SQLException;
    public int insertar(Persona persona) throws SQLException;
    public int actualizar(Persona persona) throws SQLException;
    public int eliminar (Persona persona) throws SQLException;
}
