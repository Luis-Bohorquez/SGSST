package com.sgsss.modelo;

public class Paciente {
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String tipoSangre;
    private String telefono;
    private String direccion;
    private int estrato;
    private String acudiente;

    public Paciente() {}

    public Paciente(String numeroIdentificacion, String nombres, String apellidos, String tipoSangre, 
                    String telefono, String direccion, int estrato, String acudiente) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoSangre = tipoSangre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estrato = estrato;
        this.acudiente = acudiente;
    }

    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String id) { this.numeroIdentificacion = id; }
    public String getNombres() { return nombres; }
    public void setNombres(String n) { this.nombres = n; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String a) { this.apellidos = a; }
    public String getTipoSangre() { return tipoSangre; }
    public void setTipoSangre(String rh) { this.tipoSangre = rh; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String t) { this.telefono = t; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String d) { this.direccion = d; }
    public int getEstrato() { return estrato; }
    public void setEstrato(int e) { this.estrato = e; }
    public String getAcudiente() { return acudiente; }
    public void setAcudiente(String ac) { this.acudiente = ac; }

    @Override
    public String toString() {
        return "ID: " + numeroIdentificacion + " | " + nombres + " " + apellidos + " (RH: " + tipoSangre + ")";
    }
}
