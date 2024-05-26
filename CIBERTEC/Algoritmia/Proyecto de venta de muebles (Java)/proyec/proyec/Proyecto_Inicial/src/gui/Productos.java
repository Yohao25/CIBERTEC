package gui;

import datos.BaseDeDatosProductos;
import modelo.ConsultarProducto;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
public class Productos extends JInternalFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JTable tblPersona;
	private DefaultTableModel modelo;
	
	
	/**
	 * Launch the application.
	 */
	   

	/**
	 * Create the dialog.
	 */
	public Productos() {
		setClosable(true);
		setMaximizable(true);
		
		 setSize(200, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(new Color(0, 153, 153));
		setResizable(true);
		setTitle("Mantenimiento | Productos");
		setBounds(0, 0, 821, 617);
		getContentPane().setLayout(null);
		
		
		btnAdicionar = new JButton("Agregar Producto");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 10, 192, 23);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar Producto");		
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(204, 10, 192, 23);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar Producto");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(398, 10, 192, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(592, 10, 192, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 775, 520);
		getContentPane().add(scrollPane);

		tblPersona = new JTable();
		tblPersona.setBackground(new Color(51, 255, 153));
		tblPersona.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPersona);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("MODELO");
		modelo.addColumn("PRECIO ($)");
		tblPersona.setModel(modelo);
		
		ajustarAnchoColumnas();
		listar();
		
		tblPersona.getSelectionModel().setSelectionInterval(0, 0);
		cp=new ConsultarProducto();
		
		/*addInternalFrameListener((InternalFrameListener) new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarFormulario();
            }
        });*/
		
		 addInternalFrameListener(new InternalFrameAdapter() {
	            @Override
	            public void internalFrameClosing(InternalFrameEvent e) {
	                cerrarFormulario();
	            }
	        });
	}

	//  Declaración global
	ConsultarProducto cp = new ConsultarProducto();
	
	int codigo, stock;
	String nombre, Modelo;
	double Precio;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
	    codigo = cp.codigoCorrelativo();
	    nombre = "NN";
	    Modelo = "NN";
	    Precio = 88.8;
	    stock = 1;
	    
	    
	    String s = "CÓDIGO :  " + codigo + "\n" + "NOMBRE";
	    try {
	        nombre = adicionarModificar(s, nombre);
	        s += (" :  " + nombre + "\n" + "MODELO");
	        Modelo = adicionarModificar(s, Modelo);
	        if (cp.buscar(Modelo) == null) {
	            s += (" :  " + Modelo + "\n" + "PRECIO ($)");
	            Precio = Double.parseDouble(adicionarModificar(s, "" + Precio));

	          

	            int ok = verificar(s);
	            if (ok == 0) {
	                BaseDeDatosProductos nueva = new BaseDeDatosProductos(codigo, nombre, Modelo, Precio, stock);
	                cp.adicionarProducto(nueva);
	                listar();
	                tblPersona.getSelectionModel().setSelectionInterval(cp.tamaño() - 1, cp.tamaño() - 1);
	            }
	        } else
	            mensaje("El modelo " + Modelo + " ya existe");
	    } catch (Exception x) {
	       
	    }
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
	    int selectedRow = tblPersona.getSelectedRow();
	    if (selectedRow >= 0) {
	        BaseDeDatosProductos x = cp.obtener(selectedRow);
	        if (x != null) {
	            mensaje("CÓDIGO :  " + x.getCodigo() + "\n" +
	                    "NOMBRE :  " + x.getNombre() + "\n" +
	                    "MODELO :  " + x.getModelo() + "\n" +
	                    "PRECIO :  " + x.getPrecio() + " $ ");
	                    
	        } else {
	            mensaje("No se pudo obtener la información del producto.");
	        }
	    } else {
	        mensaje("Por favor, selecciona un producto para consultar.");
	    }
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		int posFila = tblPersona.getSelectedRow();
		BaseDeDatosProductos x = cp.obtener(posFila);
		String s = "CÓDIGO :  " + x.getCodigo() + "\n" + "NOMBRE";
		try {
			nombre = adicionarModificar(s, x.getNombre());
			s += (" :  " + nombre + "\n" + "MODELO :  " + x.getModelo() + "\n" + "PRECIO ($)");
			Precio = Double.parseDouble(adicionarModificar(s, "" + x.getPrecio()));
			s += (" :  " + Precio + "\n");
		
		} 
		catch (Exception e) {	
		}	
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		int posFila = tblPersona.getSelectedRow();
		BaseDeDatosProductos x = cp.obtener(posFila);
		int ok = confirmar("¿ Desea eliminar el registro ?");
		if (ok == 0) {
			cp.eliminar(x);
			listar();
			if (cp.tamaño() > 0) {
				if (posFila == tblPersona.getRowCount())
					posFila --;
				tblPersona.getSelectionModel().setSelectionInterval(posFila, posFila);
			}
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
	//  Métodos sin valor de retorno (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblPersona.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // modelo
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // precio
		
	}
	void listar() {
		BaseDeDatosProductos x;
		modelo.setRowCount(0);
		for (int i=0; i<cp.tamaño(); i++) {
			x = cp.obtener(i);
			Object[] fila = { x.getCodigo(),
					          x.getNombre(),
					          x.getModelo(),
					          x.getPrecio()};
					        
					          
					          
					          modelo.addRow(fila);
			
		}
	}
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Persona", 1);
	}	
	
	private void cerrarFormulario() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar?", "Cerrar Formulario",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            dispose(); 
        }
    }
	//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	
	double ajustar(double numero) {
		return (int)(numero * 10) / 10.0;
	}
	String adicionarModificar(String s, String texto) {
		return JOptionPane.showInputDialog(this, s, "Persona", -1, null, null, texto).toString();
	}
	int verificar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Persona", 0, 3, null);
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Persona", 0, 0, null);
	}
	
}