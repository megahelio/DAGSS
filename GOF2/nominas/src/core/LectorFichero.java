package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorFichero {
    public static List<Empleado> leerArchivo(String archivo) {
        List<Empleado> empleados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\t");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    String escala = partes[1];
                    int añosTrabajados = Integer.parseInt(partes[2]);
                    boolean cargoGestion = partes[3].equalsIgnoreCase("SI");

                    Empleado empleado = new Empleado(nombre, escala, añosTrabajados, cargoGestion);

                    empleados.add(empleado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empleados;
    }
}
