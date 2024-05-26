package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import datos.BaseDeDatosProductos;
import datos.BaseDeDatosVentas;

public class GenerarReportes extends JInternalFrame implements ActionListener {
    private static final String Object = null;
	private JList<BaseDeDatosProductos> listaProductos;
    private JTextArea areaMensaje;
    private List productos;

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentasRealizadas dialog = new VentasRealizadas();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public GenerarReportes(BaseDeDatosVentas baseDeDatosVentas) {
        setTitle("Generar Reportes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Asumiendo que hay un método para obtener todos los productos
        // y que este método devuelve una lista de productos.
        // Asegúrate de que el método exista y devuelva el tipo correcto.
        productos = baseDeDatosVentas.obtenerTodosLosProductos(); // Corregido: asumiendo que hay un método para obtener todos los productos

        // Corregido: Convertir la lista de productos a un array de BaseDeDatosProductos
        BaseDeDatosProductos[] productosArray = new BaseDeDatosProductos[productos()];
        productosArray = (BaseDeDatosProductos[])(new Object[0]);

        listaProductos = new JList<>(productosArray);
        listaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProductos.addListSelectionListener(e -> verificarAlerta());

        areaMensaje = new JTextArea();
        areaMensaje.setEditable(false);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane(listaProductos);
        scrollPane.setBounds(0, 0, 258, 370);
        getContentPane().add(scrollPane);
        JScrollPane scrollPane_1 = new JScrollPane(areaMensaje);
        scrollPane_1.setBounds(258, 0, 226, 370);
        getContentPane().add(scrollPane_1);
    }

	private int productos() {
		// TODO Auto-generated method stub
		return 0;
	}

	private Object verificarAlerta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}