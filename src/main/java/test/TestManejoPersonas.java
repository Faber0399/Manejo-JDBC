package test;

import java.util.List;

import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        List <Persona> personas=personaDao.seleccionar();
        for (Persona persona: personas){
            System.out.println(persona);
        }
        
    }
}
