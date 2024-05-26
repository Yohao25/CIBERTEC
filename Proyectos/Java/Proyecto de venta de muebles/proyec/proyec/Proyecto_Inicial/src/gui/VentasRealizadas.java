package gui;

import javax.swing.*;

import datos.BaseDeDatosVentas;
import modelo.Venta;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VentasRealizadas extends JInternalFrame implements ActionListener {
    private static JTable tablaVentas;
    private static BaseDeDatosVentas baseDeDatosVentas;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public VentasRealizadas() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setMaximizable(true);
        setTitle("Generar Reportes");
        setSize(800, 400);
        getContentPane().setLayout(new BorderLayout());

        this.baseDeDatosVentas = new BaseDeDatosVentas();

        // Crear modelo de tabla con los datos de las ventas
        String[] columnNames = {"Producto", "Fecha", "Monto", "Cliente"};
        Object[][] data = obtenerDatosVentas();
        JTable table = new JTable(data, columnNames);

        // Configurar la tabla
        tablaVentas = table;
        JScrollPane scrollPane = new JScrollPane(tablaVentas);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(this);
        getContentPane().add(closeButton, BorderLayout.SOUTH);
    }

    private Object[][] obtenerDatosVentas() {
        List<Venta> ventas = baseDeDatosVentas.obtenerVentas();
        Object[][] data = new Object[ventas.size()][4];
        for (int i = 0; i < ventas.size(); i++) {
            Venta venta = ventas.get(i);
            data[i][0] = venta.getProducto();
            data[i][1] = dateFormat.format(venta.getFecha());
            data[i][2] = venta.getPrecio();
            data[i][3] = venta.getCliente();
        }
        return data;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if (e.getSource() instanceof JButton && ((JButton) e.getSource()).getText().equals("Cerrar")) {
	            dispose();
	        }
	}
	
	
	
}
