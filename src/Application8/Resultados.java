/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application8;

/**
 *
 * @author jhord
 */
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Resultados {

    // Pone la lista principal en el JTextArea (listado)
    public static void mostrarListado(ArrayList<Producto> lista, JTextArea area) {
        StringBuilder sb = new StringBuilder();
        sb.append("Total: ").append(lista.size()).append(" productos\n\n");
        for (Producto p : lista) {
            sb.append(p.toString()).append("\n");
        }
        area.setText(sb.toString());
    }

    // Muestra un único producto (o mensaje) en el área de resultados
    public static void mostrarProductoEncontrado(Producto p, JTextArea area) {
        if (p == null) {
            area.setText("No se encontró el producto.\n");
        } else {
            area.setText("Producto encontrado:\n" + p.toString() + "\n");
        }
    }

    // Muestra una lista de resultados separados por criterio
    public static void mostrarListaResultados(ArrayList<Producto> lista, String criterio, JTextArea area) {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultados para -> ").append(criterio).append("\n");
        sb.append("Encontrados: ").append(lista.size()).append("\n\n");
        if (lista.isEmpty()) {
            sb.append("No se encontraron resultados.\n");
        } else {
            for (Producto p : lista) {
                sb.append(p.toString()).append("\n");
            }
        }
        area.setText(sb.toString());
    }
}
