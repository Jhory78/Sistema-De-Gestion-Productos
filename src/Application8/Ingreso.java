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
import javax.swing.JOptionPane;

public class Ingreso {
    // Agrega un producto a la lista si es válido y no existe el código.
    public static boolean agregarProducto(ArrayList<Producto> lista,
                                          String codigo, String nombre,
                                          String fabricante, String tipo) {
        codigo = codigo == null ? "" : codigo.trim();
        nombre = nombre == null ? "" : nombre.trim();
        fabricante = fabricante == null ? "" : fabricante.trim();
        tipo = tipo == null ? "" : tipo.trim();

        if (codigo.isEmpty() || nombre.isEmpty() || fabricante.isEmpty() || tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // validar duplicado de código
        for (Producto p : lista) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                JOptionPane.showMessageDialog(null, "El código ya existe.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        lista.add(new Producto(codigo, nombre, fabricante, tipo));
        return true;
    }
}
