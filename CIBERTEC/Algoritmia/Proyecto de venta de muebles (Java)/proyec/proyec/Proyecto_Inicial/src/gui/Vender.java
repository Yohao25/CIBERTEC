package gui;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import datos.BaseDeDatosProductos;
import datos.BaseDeDatosClientes;
import modelo.ConsultarProducto;
import modelo.Venta;
import datos.BaseDeDatosVentas;

public class Vender extends JInternalFrame implements ActionListener {
    private JComboBox<String> modeloComboBox;
    private JTextField clienteTextField;
    private JTextField dniRucTextField;
    private JTextField cantidadTextField;
    private JTextField fechaTextField;

    private BaseDeDatosVentas baseDeDatosVentas; 
    private JButton btnVender;
    private ConsultarProducto consultarProducto;

    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender dialog = new Vender();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public Vender() {
    	setMaximizable(true);
    	setClosable(true);
    }
    {

        setTitle("Generar Ventas");
        setSize(708, 282);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(10, 24, 70, 20);
        panel.add(lblModelo);
        
        this.baseDeDatosVentas = new BaseDeDatosVentas();
        this.consultarProducto = new ConsultarProducto();
        
        modeloComboBox = new JComboBox<>();
        
        cargarModelosCombobox();
        
        modeloComboBox.setBackground(new Color(255, 255, 255));
        modeloComboBox.setBounds(140, 24, 150, 20);
        modeloComboBox.addActionListener(this);
        panel.add(modeloComboBox);

        JLabel lblCliente = new JLabel("Nombre del Cliente:");
        lblCliente.setBounds(345, 24, 120, 20);
        panel.add(lblCliente);

        clienteTextField = new JTextField();
        clienteTextField.setBounds(475, 24, 150, 20);
        panel.add(clienteTextField);

        JLabel lblDniRuc = new JLabel("DNI/RUC:");
        lblDniRuc.setBounds(345, 70, 70, 20);
        panel.add(lblDniRuc);

        dniRucTextField = new JTextField();
        dniRucTextField.setBounds(475, 70, 150, 20);
        panel.add(dniRucTextField);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 70, 70, 20);
        panel.add(lblCantidad);

        cantidadTextField = new JTextField();
        cantidadTextField.setBounds(140, 70, 150, 20);
        panel.add(cantidadTextField);

        JLabel lblFecha = new JLabel("Fecha de la Venta:");
        lblFecha.setBounds(10, 113, 120, 20);
        panel.add(lblFecha);

        fechaTextField = new JTextField();
        fechaTextField.setEditable(false);
        fechaTextField.setBounds(140, 113, 150, 20);
        panel.add(fechaTextField);

        btnVender = new JButton("Generar Venta");
        btnVender.setBounds(266, 200, 124, 30);
        btnVender.setActionCommand("Vender");
        btnVender.addActionListener(this);
        panel.add(btnVender);

        setContentPane(panel);
        setLocation(0,0);
        setVisible(true);
        
        /*addInternalFrameListener((InternalFrameListener) new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrarFormulario();
        }
    });*/
	
	 addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                cerrarFormularioCliente();
            }
        });
    }
    
    private void cargarModelosCombobox() {
    	String[] modelos = this.consultarProducto.obtenerModelos();
    	int cantidadModelos = modelos.length;
    	
    	modeloComboBox.addItem("Seleccionar modelo");
    	
    	for(int i = 0; i < cantidadModelos; i++) {
    		modeloComboBox.addItem(modelos[i]);
    	}
    }

    
   
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == modeloComboBox) {
            String modeloSeleccionado = (String) modeloComboBox.getSelectedItem();
            // Usa consultarProducto en lugar de baseDeDatosVentas
            BaseDeDatosProductos producto = consultarProducto.obtenerProductoPorModelo(modeloSeleccionado);

            if (producto != null) {
                double precio = producto.getPrecio();
                double igv = calcularIGV(precio);
                // Aquí puedes hacer algo con el precio y el IGV, por ejemplo, mostrarlos o guardarlos
            } else {
                JOptionPane.showMessageDialog(this, "El producto no fue encontrado en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnVender) {
        	registrarVenta();
        	JOptionPane.showMessageDialog(this, "Venta registrada", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private double calcularIGV(double precio) {
        // Lógica para calcular el IGV 
        return precio * 0.18;
    }

    private void registrarVenta() {
        String modeloSeleccionado = (String) modeloComboBox.getSelectedItem();
        BaseDeDatosProductos productos = consultarProducto.obtenerProductoPorModelo(modeloSeleccionado);
        String cliente = clienteTextField.getText();
        String dniRuc = dniRucTextField.getText();
        int cantidad;

        try {
            cantidad = Integer.parseInt(cantidadTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el producto de la base de datos
        BaseDeDatosProductos producto = consultarProducto.buscar(modeloSeleccionado);

        if (producto != null) {
            baseDeDatosVentas.registrarVenta(cliente, dniRuc, producto, cantidad, obtenerFechaActual());
        } else {
            JOptionPane.showMessageDialog(this, "El producto no fue encontrado en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResultados() {
        //  mostrar resultados en el área de texto
        // ...

    }

    

    private String obtenerFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaActual = new Date();
        return formatoFecha.format(fechaActual);	
    }
	
	private void cerrarFormularioCliente() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar la ventana?", "Cerrar cong. Cliente",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            dispose(); 
        }
    }
}