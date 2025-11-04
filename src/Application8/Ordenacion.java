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
import java.util.Collections;
import java.util.Comparator;

public class Ordenacion {

    // Ordena por código (alfabético)
    public static void ordenarPorCodigo(ArrayList<Producto> lista) {
        Collections.sort(lista, Comparator.comparing(p -> p.getCodigo().toLowerCase()));
    }

    // Ordena por fabricante y, como secundario, por código
    public static void ordenarPorFabricante(ArrayList<Producto> lista) {
        Collections.sort(lista, Comparator.comparing((Producto p) -> p.getFabricante().toLowerCase()).thenComparing(p -> p.getCodigo().toLowerCase()));
    }

    // Ordena por tipo y luego por código
    public static void ordenarPorTipo(ArrayList<Producto> lista) {
        Collections.sort(lista, Comparator.comparing((Producto p) -> p.getTipo().toLowerCase()).thenComparing(p -> p.getCodigo().toLowerCase()));
    }
}

