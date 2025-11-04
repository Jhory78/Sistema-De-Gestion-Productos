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

public class Busqueda {

    // Búsqueda binaria por código. PRECONDICIÓN: lista ordenada por código.
    // Devuelve el índice en la lista o -1 si no se encuentra.
    public static int buscarPorCodigoBinario(ArrayList<Producto> lista, String codigo) {
        int izq = 0;
        int der = lista.size() - 1;
        codigo = codigo == null ? "" : codigo.trim().toLowerCase();

        while (izq <= der) {
            int mid = (izq + der) / 2;
            String codigoMid = lista.get(mid).getCodigo().toLowerCase();
            int cmp = codigoMid.compareTo(codigo);
            if (cmp == 0) return mid;
            if (cmp < 0) izq = mid + 1;
            else der = mid - 1;
        }
        return -1;
    }

    // Búsqueda lineal por fabricante -> devuelve lista de coincidencias
    public static ArrayList<Producto> buscarPorFabricanteLineal(ArrayList<Producto> lista, String fabricante) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        if (fabricante == null) fabricante = "";
        fabricante = fabricante.trim().toLowerCase();

        for (Producto p : lista) {
            if (p.getFabricante().toLowerCase().equals(fabricante)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    // Búsqueda lineal por tipo -> devuelve lista de coincidencias
    public static ArrayList<Producto> buscarPorTipoLineal(ArrayList<Producto> lista, String tipo) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        if (tipo == null) tipo = "";
        tipo = tipo.trim().toLowerCase();

        for (Producto p : lista) {
            if (p.getTipo().toLowerCase().equals(tipo)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }
}
