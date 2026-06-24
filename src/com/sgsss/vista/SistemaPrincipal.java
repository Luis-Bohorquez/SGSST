package com.sgsss.vista;

import com.sgsss.dao.PacienteDAO;
import com.sgsss.modelo.Paciente;
import java.util.Scanner;

public class SistemaPrincipal {
    public static void main(String[] args) {
        PacienteDAO dao = new PacienteDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("=== ENTORNOS CONTENEDORIZADOS DOCKER - SGSSS ===");

        do {
            System.out.println("\n[1] Registrar | [2] Listar | [3] Actualizar | [4] Eliminar | [5] Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Identificación: "); String id = scanner.nextLine();
                    System.out.print("Nombres: "); String nom = scanner.nextLine();
                    System.out.print("Apellidos: "); String ape = scanner.nextLine();
                    System.out.print("RH: "); String rh = scanner.nextLine();
                    System.out.print("Teléfono: "); String tel = scanner.nextLine();
                    System.out.print("Dirección: "); String dir = scanner.nextLine();
                    System.out.print("Estrato: "); int est = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Acudiente: "); String acu = scanner.nextLine();

                    if (dao.registrarPaciente(new Paciente(id, nom, ape, rh, tel, dir, est, acu))) {
                        System.out.println("✅ Guardado con éxito en el contenedor PostgreSQL.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- PACIENTES REGISTRADOS ---");
                    for (Paciente p : dao.listarPacientes()) {
                        System.out.println(p + " | Dir: " + p.getDireccion() + " | Acudiente: " + p.getAcudiente());
                    }
                    break;

                case 3:
                    System.out.print("Cédula a actualizar: "); String actId = scanner.nextLine();
                    System.out.print("Nuevos Nombres: "); String nNom = scanner.nextLine();
                    System.out.print("Nuevos Apellidos: "); String nApe = scanner.nextLine();
                    System.out.print("Nuevo RH: "); String nRh = scanner.nextLine();
                    System.out.print("Nuevo Teléfono: "); String nTel = scanner.nextLine();
                    System.out.print("Nueva Dirección: "); String nDir = scanner.nextLine();
                    System.out.print("Nuevo Estrato: "); int nEst = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nuevo Acudiente: "); String nAcu = scanner.nextLine();

                    if (dao.actualizarPaciente(new Paciente(actId, nNom, nApe, nRh, nTel, nDir, nEst, nAcu))) {
                        System.out.println("✅ Registro actualizado.");
                    }
                    break;

                case 4:
                    System.out.print("Cédula a eliminar: "); String delId = scanner.nextLine();
                    if (dao.eliminarPaciente(delId)) {
                        System.out.println("✅ Registro eliminado.");
                    }
                    break;
            }
        } while (opcion != 5);

        System.out.println("Desconexión segura de la red Docker.");
        scanner.close();
    }
}
