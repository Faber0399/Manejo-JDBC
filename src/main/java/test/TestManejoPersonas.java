package test;

import java.util.List;

import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        // Se inserta un nuevo objeto de tipo Persona
        Persona personaN = new Persona("Ligia","Causil","ligia@gmail.com","310655"); 
        Persona personaNueva = new Persona(9,"Pedro000","Causil","pedro@gmail.com","310655"); 
        //Persona personaEliminar=new Persona(8);
        //personaDao.insertar(personaN);
        personaDao.actualizar(personaNueva );
        //personaDao.eliminar(personaEliminar);
        List <Persona> personas=personaDao.seleccionar();
        for (Persona persona: personas){
            System.out.println(persona);
        }
    }
    
}
