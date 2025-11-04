/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application8;

/**
 *
 * @author jhord
 */

public class Producto {
    private String codigo;
    private String nombre;
    private String fabricante;
    private String tipo;

    public Producto(String codigo, String nombre, String fabricante, String tipo) {
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
        this.fabricante = fabricante.trim();
        this.tipo = tipo.trim();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format("Código: %s | Nombre: %s | Fabricante: %s | Tipo: %s",
                codigo, nombre, fabricante, tipo);
    }
}
