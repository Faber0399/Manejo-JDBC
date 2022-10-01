package datos;

import java.sql.*;
import java.util.*;

import domain.Persona;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM test.persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
    private static final String SQL_UPDATED = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE idPersona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";
    private Connection ConexionTransaccion;

    
    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccion) {
        ConexionTransaccion = conexionTransaccion;
    }

    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList();
        try {
            conn = this.ConexionTransaccion !=null ? this.ConexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        }  finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if(this.ConexionTransaccion==null){
                    Conexion.close(conn);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
        return personas;

    }

    public int insertar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conn = this.ConexionTransaccion !=null ? this.ConexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApeliido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registro = stmt.executeUpdate();
        }  finally {

            try {
                Conexion.close(stmt);
                if(this.ConexionTransaccion==null){
                    Conexion.close(conn);
                }
                
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return registro;

    }
    public int actualizar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro=0;
        try {
            conn = this.ConexionTransaccion !=null ? this.ConexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATED);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApeliido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registro=stmt.executeUpdate();
        }finally{
            try {
                Conexion.close(stmt);
                if(this.ConexionTransaccion==null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
            
        }
        return registro;

    }
    public int eliminar (Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro=0;
        try {
            conn = this.ConexionTransaccion !=null ? this.ConexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registro=stmt.executeUpdate();
        } finally{
            try {
                Conexion.close(stmt);
                if(this.ConexionTransaccion==null){
                    Conexion.close(conn);
                }
                
            } catch (SQLException e) {

                e.printStackTrace();
            }
            
        }
        return registro;
        
    }
}
