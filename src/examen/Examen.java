/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:mariadb://127.0.0.1:3306/examen";
        String usuario = "root";
        String contraseña = "computacion18";
        java.sql.Connection conexion = null;
        int Codigo;
        String Nombre,Profesion;
        Scanner Entrada = new Scanner(System.in);

        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {

                System.out.println("Ingrese su Nombre");
                Nombre = Entrada.nextLine();
                System.out.println("Ingrese su Codigo");
                Codigo = Entrada.nextInt();
                System.out.println("Ingrese su Profesion");
                Profesion = Entrada.nextLine();

                String consultaSQL = "INSERT INTO profesor (Codigo, Nombre, Profesion) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);

                preparedStatement.setInt(1, Codigo);
                preparedStatement.setString(2, Nombre);
                preparedStatement.setString(3, Profesion);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Se han agregado los datos a la base de datos.");
                } else {
                    System.out.println("No se han podido agregar ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se ha podido insertar los datos: " + e.getMessage());
        }
    }

}
