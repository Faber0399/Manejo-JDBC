package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import datos.*;
import domain.Persona;

public class TestManejoPersonas {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Persona personaN = new Persona("Blanca","Causil","Blanca@gmail.com","310655"); 
            Persona personaNueva = new Persona(9,"Juan","Causil","pedro@gmail.com","310655");
            //personaDAO.insertar(personaN);
            //personaDAO.actualizar(personaNueva);
            List <Persona> personas=personaDAO.seleccionar();
            for (Persona persona: personas){
                System.out.println(persona);
        }
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Entramos al RollBack ");
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        
        
    }
    
}
