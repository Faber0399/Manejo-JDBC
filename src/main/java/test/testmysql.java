package test;

import java.sql.*;

public class testmysql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            Statement instruction = conexion.createStatement();
            String sql = "SELECT idPersona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruction.executeQuery(sql);
            while (resultado.next()){
                System.out.print(" Id-Persona: "+ resultado.getInt("idPersona"));
                System.out.print(" Nombre: "+ resultado.getString("nombre"));
                System.out.print(" Apellido: "+ resultado.getString("apellido"));
                System.out.print(" email: "+ resultado.getString("email"));
                System.out.print(" telefono: "+ resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruction.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
}
