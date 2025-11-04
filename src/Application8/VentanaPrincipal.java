/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application8;

/**
 *
 * @author jhord
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private ArrayList<Producto> productos = new ArrayList<>();

    private JTextField txtCodigo, txtNombre, txtFabricante, txtTipo, txtBuscar;
    private JButton btnAgregar, btnOrdenarCodigo, btnBuscarCodigoBinaria,
            btnOrdenarFabricante, btnBuscarFabricante,
            btnOrdenarTipo, btnBuscarTipo;
    private JTable tablaListado;
    private JTextArea areaResultados;
    private DefaultTableModel modeloTabla;

    public VentanaPrincipal() {
        setTitle("Gestión de Productos - Sistema de Inventario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        
        // Configurar colores
        Color colorPrincipal = new Color(41, 128, 185);
        Color colorSecundario = new Color(52, 152, 219);
        Color colorFondo = new Color(245, 245, 245);
        Color colorBorde = new Color(220, 220, 220);
        
        getContentPane().setBackground(colorFondo);

        // === Panel de encabezado ===
        JPanel panelHeader = new JPanel();
        panelHeader.setBounds(0, 0, 1000, 40);
        panelHeader.setBackground(colorPrincipal);
        panelHeader.setLayout(null);
        
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN DE PRODUCTOS");
        lblTitulo.setBounds(10, 5, 500, 30);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelHeader.add(lblTitulo);
        add(panelHeader);

        // === Panel de ingreso de datos ===
        JPanel panelIngreso = new JPanel();
        panelIngreso.setBounds(10, 50, 980, 80);
        panelIngreso.setBackground(Color.WHITE);
        panelIngreso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBorde), "Agregar Nuevo Producto"));
        panelIngreso.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 25, 60, 25);
        panelIngreso.add(lblCodigo);
        txtCodigo = new JTextField();
        txtCodigo.setBounds(70, 25, 80, 25);
        panelIngreso.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(160, 25, 60, 25);
        panelIngreso.add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(220, 25, 180, 25);
        panelIngreso.add(txtNombre);

        JLabel lblFabricante = new JLabel("Fabricante:");
        lblFabricante.setBounds(410, 25, 75, 25);
        panelIngreso.add(lblFabricante);
        txtFabricante = new JTextField();
        txtFabricante.setBounds(485, 25, 120, 25);
        panelIngreso.add(txtFabricante);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(615, 25, 40, 25);
        panelIngreso.add(lblTipo);
        txtTipo = new JTextField();
        txtTipo.setBounds(655, 25, 120, 25);
        panelIngreso.add(txtTipo);

        btnAgregar = new JButton("Agregar Producto");
        btnAgregar.setBounds(785, 25, 150, 25);
        btnAgregar.setBackground(colorSecundario);
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);
        panelIngreso.add(btnAgregar);

        add(panelIngreso);

        // === Panel de búsqueda y ordenamiento ===
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setBounds(10, 140, 980, 80);
        panelBusqueda.setBackground(Color.WHITE);
        panelBusqueda.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBorde), "Búsqueda y Ordenamiento"));
        panelBusqueda.setLayout(null);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setBounds(10, 25, 50, 25);
        panelBusqueda.add(lblBuscar);
        txtBuscar = new JTextField();
        txtBuscar.setBounds(60, 25, 120, 25);
        panelBusqueda.add(txtBuscar);

        // Primera fila de botones
        btnOrdenarCodigo = crearBoton("Ordenar por Código", 190, 25, 150);
        panelBusqueda.add(btnOrdenarCodigo);

        btnBuscarCodigoBinaria = crearBoton("Buscar Código (Binaria)", 350, 25, 170);
        panelBusqueda.add(btnBuscarCodigoBinaria);

        btnOrdenarFabricante = crearBoton("Ordenar por Fabricante", 530, 25, 170);
        panelBusqueda.add(btnOrdenarFabricante);

        btnBuscarFabricante = crearBoton("Buscar Fabricante", 710, 25, 150);
        panelBusqueda.add(btnBuscarFabricante);

        // Segunda fila de botones
        btnOrdenarTipo = crearBoton("Ordenar por Tipo", 190, 55, 150);
        panelBusqueda.add(btnOrdenarTipo);

        btnBuscarTipo = crearBoton("Buscar por Tipo", 350, 55, 150);
        panelBusqueda.add(btnBuscarTipo);

        add(panelBusqueda);

        // === Panel de listado ===
        JPanel panelListado = new JPanel();
        panelListado.setBounds(10, 230, 650, 370);
        panelListado.setBackground(Color.WHITE);
        panelListado.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBorde), "Listado de Productos"));
        panelListado.setLayout(new BorderLayout());

        String[] columnas = {"Código", "Nombre", "Fabricante", "Tipo"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        tablaListado = new JTable(modeloTabla);
        tablaListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaListado.getTableHeader().setReorderingAllowed(false);
        
        // Mejorar apariencia de la tabla
        tablaListado.setRowHeight(25);
        tablaListado.getTableHeader().setBackground(colorPrincipal);
        tablaListado.getTableHeader().setForeground(Color.WHITE);
        tablaListado.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        
        JScrollPane scrollTabla = new JScrollPane(tablaListado);
        panelListado.add(scrollTabla, BorderLayout.CENTER);
        add(panelListado);

        // === Panel de resultados ===
        JPanel panelResultados = new JPanel();
        panelResultados.setBounds(670, 230, 320, 370);
        panelResultados.setBackground(Color.WHITE);
        panelResultados.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBorde), "Resultados de Búsqueda"));
        panelResultados.setLayout(new BorderLayout());

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaResultados.setMargin(new Insets(5, 5, 5, 5));
        
        JScrollPane scrollResultados = new JScrollPane(areaResultados);
        panelResultados.add(scrollResultados, BorderLayout.CENTER);
        add(panelResultados);

        // === Eventos (mantener los mismos) ===
        btnAgregar.addActionListener(e -> {
            boolean ok = Ingreso.agregarProducto(productos,
                    txtCodigo.getText(), txtNombre.getText(),
                    txtFabricante.getText(), txtTipo.getText());
            if (ok) {
                actualizarTabla();
                areaResultados.setText("✓ Producto agregado correctamente.\n");
                txtCodigo.setText("");
                txtNombre.setText("");
                txtFabricante.setText("");
                txtTipo.setText("");
            }
        });

        btnOrdenarCodigo.addActionListener(e -> {
            Ordenacion.ordenarPorCodigo(productos);
            actualizarTabla();
            areaResultados.setText("✓ Listado ordenado por código.\n");
        });

        btnBuscarCodigoBinaria.addActionListener(e -> {
            String clave = txtBuscar.getText().trim();
            if (clave.isEmpty()) {
                mostrarAdvertencia("Ingrese un código a buscar.");
                return;
            }
            Ordenacion.ordenarPorCodigo(productos);
            int idx = Busqueda.buscarPorCodigoBinario(productos, clave);
            Producto encontrado = (idx >= 0) ? productos.get(idx) : null;
            Resultados.mostrarProductoEncontrado(encontrado, areaResultados);
            actualizarTabla();
        });

        btnOrdenarFabricante.addActionListener(e -> {
            Ordenacion.ordenarPorFabricante(productos);
            actualizarTabla();
            areaResultados.setText("✓ Listado ordenado por fabricante.\n");
        });

        btnBuscarFabricante.addActionListener(e -> {
            String fab = txtBuscar.getText().trim();
            if (fab.isEmpty()) {
                mostrarAdvertencia("Ingrese fabricante a buscar.");
                return;
            }
            var encontrados = Busqueda.buscarPorFabricanteLineal(productos, fab);
            Resultados.mostrarListaResultados(encontrados, "Fabricante: " + fab, areaResultados);
        });

        btnOrdenarTipo.addActionListener(e -> {
            Ordenacion.ordenarPorTipo(productos);
            actualizarTabla();
            areaResultados.setText("✓ Listado ordenado por tipo.\n");
        });

        btnBuscarTipo.addActionListener(e -> {
            String tipo = txtBuscar.getText().trim();
            if (tipo.isEmpty()) {
                mostrarAdvertencia("Ingrese tipo a buscar.");
                return;
            }
            var encontrados = Busqueda.buscarPorTipoLineal(productos, tipo);
            Resultados.mostrarListaResultados(encontrados, "Tipo: " + tipo, areaResultados);
        });

        // === Datos iniciales ===
        poblarEjemplo();
        actualizarTabla();
    }

    private JButton crearBoton(String texto, int x, int y, int ancho) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, 25);
        boton.setBackground(new Color(52, 152, 219));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.PLAIN, 11));
        return boton;
    }

    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    private void poblarEjemplo() {
        productos.add(new Producto("0001", "Mouse", "logitech", "Periférico"));
        productos.add(new Producto("0002", "Teclado", "logitech", "Periférico"));
        productos.add(new Producto("0004", "Monitor 24\"", "ViewTech", "Pantalla"));
        productos.add(new Producto("0123", "Crucial P3 Plus 1TB", "Crucial", "Almacenamiento"));
        productos.add(new Producto("0945", "NVIDIA RTX 3060 8GB", "NVIDIA", "Video"));
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Producto p : productos) {
            modeloTabla.addRow(new Object[]{
                    p.getCodigo(), p.getNombre(), p.getFabricante(), p.getTipo()
            });
        }
    }
}
