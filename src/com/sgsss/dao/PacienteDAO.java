package com.sgsss.dao;

import com.sgsss.modelo.ConexionDB;
import com.sgsss.modelo.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public boolean registrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (numero_identificacion, nombres, apellidos, tipo_sangre, telefono, direccion, estrato, acudiente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, paciente.getNumeroIdentificacion());
            ps.setString(2, paciente.getNombres());
            ps.setString(3, paciente.getApellidos());
            ps.setString(4, paciente.getTipoSangre());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getDireccion());
            ps.setInt(7, paciente.getEstrato());
            ps.setString(8, paciente.getAcudiente());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente ORDER BY apellidos ASC";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Paciente(
                    rs.getString("numero_identificacion"), rs.getString("nombres"),
                    rs.getString("apellidos"), rs.getString("tipo_sangre"),
                    rs.getString("telefono"), rs.getString("direccion"),
                    rs.getInt("estrato"), rs.getString("acudiente")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nombres=?, apellidos=?, tipo_sangre=?, telefono=?, direccion=?, estrato=?, acudiente=? WHERE numero_identificacion=?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, paciente.getNombres());
            ps.setString(2, paciente.getApellidos());
            ps.setString(3, paciente.getTipoSangre());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getDireccion());
            ps.setInt(6, paciente.getEstrato());
            ps.setString(7, paciente.getAcudiente());
            ps.setString(8, paciente.getNumeroIdentificacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPaciente(String id) {
        String sql = "DELETE FROM paciente WHERE numero_identificacion = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
