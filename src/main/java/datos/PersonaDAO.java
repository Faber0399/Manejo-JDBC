package datos;

import java.sql.*;
import java.util.*;

import domain.Persona;

public class PersonaDAO {
    private static final String SQL_SELECT= "SELECT idPersona, nombre, apellido, email, telefono FROM test.persona";

    public List<Persona> seleccionar (){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while(rs.next()){
                int idPersona=rs.getInt("idPersona");
                String nombre =rs.getString("nombre");
                String apellido =rs.getString("apellido");
                String email =rs.getString("email");
                String telefono =rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
            

        }
        return personas;

    }
}
