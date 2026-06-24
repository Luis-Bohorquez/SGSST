package com.sgsss.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Apunta al nombre del servicio en docker-compose
    private static final String URL = "jdbc:postgresql://db-postgres:5432/SGSSS_Pro";
    private static final String USER = "postgres";
    private static final String PASSWORD = "tu_contraseña";

    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver de PostgreSQL no encontrado en el contenedor.", e);
        }
    }
}
