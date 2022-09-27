package test;

import java.util.List;

import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        // Se inserta un nuevo objeto de tipo Persona
        Persona personaN = new Persona("Ligia","Causil","ligia@gmail.com","310655"); 
        personaDao.insertar(personaN);
        List <Persona> personas=personaDao.seleccionar();
        for (Persona persona: personas){
            System.out.println(persona);
        }
    }
    
}
