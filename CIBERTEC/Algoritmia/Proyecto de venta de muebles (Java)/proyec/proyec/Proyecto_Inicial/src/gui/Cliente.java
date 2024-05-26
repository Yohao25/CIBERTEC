package gui;

import modelo.ConsultarProducto;
import modelo.consultarCliente;
import datos.BaseDeDatosClientes;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Cliente extends JInternalFrame implements ActionListener, KeyListener, MouseListener {
	
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDni;
	private JLabel lblPeso;
	private JLabel lblClienteNuevo;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtRUC;
	private JComboBox <String> cboClienteNuevo;
	private JScrollPane scrollPane;
	private JButton btnOK;
	private JButton btnAgregarCliente;
	private JButton btnModificarDatos;
	private JButton btnEliminarCliente;
	private JTable tblCliente;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente dialog = new Cliente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Cliente() {
		setMaximizable(true);
		setClosable(true);
		
		setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		setResizable(false);
		setTitle("Mantenimiento | Cliente");
		setBounds(0, 0, 800, 610);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 35, 70, 23);
		getContentPane().add(lblNombre);
	
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 60, 70, 23);
		getContentPane().add(lblDni);
		
		lblPeso = new JLabel("RUC");
		lblPeso.setBounds(10, 85, 70, 23);
		getContentPane().add(lblPeso);
		
		lblClienteNuevo = new JLabel("Cliente Nuevo");
		lblClienteNuevo.setBounds(10, 135, 86, 23);
		getContentPane().add(lblClienteNuevo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(90, 10, 86, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(90, 35, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(90, 60, 160, 23);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtRUC = new JTextField();
		txtRUC.setBounds(90, 85, 160, 23);
		getContentPane().add(txtRUC);
		txtRUC.setColumns(10);

		cboClienteNuevo = new JComboBox <String> ();
		cboClienteNuevo.setModel(new DefaultComboBoxModel(new String[] {"SI", "NO"}));
		cboClienteNuevo.setBounds(90, 135, 86, 23);
		getContentPane().add(cboClienteNuevo);

		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(240, 135, 100, 23);
		getContentPane().add(btnOK);
		
		btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.addActionListener(this);
		btnAgregarCliente.setBounds(635, 10, 150, 23);
		getContentPane().add(btnAgregarCliente);

		btnModificarDatos = new JButton("Modificar datos");
		btnModificarDatos.addActionListener(this);
		btnModificarDatos.setBounds(635, 35, 150, 23);
		getContentPane().add(btnModificarDatos);

		btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.addActionListener(this);
		btnEliminarCliente.setBounds(635, 60, 150, 23);
		getContentPane().add(btnEliminarCliente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 775, 390);
		getContentPane().add(scrollPane);

		tblCliente = new JTable();
		tblCliente.addKeyListener(this);
		tblCliente.addMouseListener(this);
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("DNI");
		modelo.addColumn("RUC");
		
		tblCliente.setModel(modelo);
		
		txtCodigo.setEditable(false);
		
		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar(0);
		editarFila();
		
		tblCliente.getSelectionModel().setSelectionInterval(0, 0);
		ap=new consultarCliente();
		
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
	
	//  Declaración global
	consultarCliente ap = new consultarCliente();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOK(arg0);
		}
		if (arg0.getSource() == btnEliminarCliente) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificarDatos) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAgregarCliente) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		if (ap.tamaño() == 0)
			btnOK.setEnabled(true);
		btnAgregarCliente.setEnabled(false);
		btnModificarDatos.setEnabled(true);
		btnEliminarCliente.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAgregarCliente.setEnabled(true);
		btnModificarDatos.setEnabled(false);
		btnEliminarCliente.setEnabled(true);
		if (ap.tamaño() == 0) {
			btnOK.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen personas");	
		}
		else {
			btnOK.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtNombre.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAgregarCliente.setEnabled(true);
		btnModificarDatos.setEnabled(true);
		btnOK.setEnabled(false);
		if (ap.tamaño() == 0) {
			btnEliminarCliente.setEnabled(false);
			mensaje("No existen personas");
		}
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				BaseDeDatosClientes x = ap.buscar(leerCodigo());
				int posFila = tblCliente.getSelectedRow();
				if (posFila == ap.tamaño()-1)
					posFila --;
				ap.eliminar(x);
				listar(posFila);
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnOK(ActionEvent arg0) {
	    int codigo = leerCodigo();
	    
	    String nombre = leerNombre();
	    String RUC = leerRUC();
	    if (nombre.length() > 0) {
	        String dni = leerDni();
	        
	        
	        if (dni.length() > 0)
	         {
	            try {
	                String ruc = leerRUC();
	                try {
	                    String nuevoCliente = ruc; 
	                    int cliente = leerPosClienteNuevo();
	                    if (btnAgregarCliente.isEnabled() == false) {
	                        if (ap.buscar(dni) == null) {
	                            BaseDeDatosClientes nueva = new BaseDeDatosClientes(codigo, nombre, dni, RUC , 1);  
	                            ap.adicionarCliente(nueva);
	                            btnAgregarCliente.setEnabled(true);
	                            listar(tblCliente.getRowCount());
	                            habilitarEntradas(false);
	                        } else {
	                            error("El DNI " + dni + " ya existe", txtDni);
	                        }
	                    }
	                    if (btnModificarDatos.isEnabled() == false) {
	                        BaseDeDatosClientes x = ap.buscar(codigo);
	                        x.setNombre(nombre);
	                        x.setDni(dni);
	                        x.setRUC(ruc);
	                        x.setClienteNuevo(cliente);
	                        btnModificarDatos.setEnabled(true);
	                        listar(tblCliente.getSelectedRow());
	                        habilitarEntradas(false);
	                    }
	                } catch (Exception x) {
	                    error("Ingrese RUC correcto", txtRUC);
	                }
	            } catch (Exception x) {
	                error("ingrese DNI correcto", txtDni);
	            }
	        } else {
	            error("ingrese NOMBRE correcto", txtNombre);
	        }
	    }
	}

	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();		
	}
	public void keyTyped(KeyEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCliente) {
			mouseClickedTblPersona(arg0);
		}
	}
	protected void mouseClickedTblPersona(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	//  Métodos tipo void (sin parámetros)
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCliente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  // dni
		tcm.getColumn(3).setPreferredWidth(anchoColumna(30));  // ruc
		

	}
	void listar(int posFila) {
		modelo.setRowCount(0);
		BaseDeDatosClientes x;
		for (int i=0; i<ap.tamaño(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigo(),
					          x.getNombre(),
					          x.getDni(),
					          x.getRUC(),
					          
					          };
			modelo.addRow(fila);
		}
		tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void editarFila() {
		if (ap.tamaño() == 0)
			limpieza();
		else {
			BaseDeDatosClientes x = ap.obtener(tblCliente.getSelectedRow());
			txtCodigo.setText("" + x.getCodigo());
			txtNombre.setText(x.getNombre());
			txtDni.setText(x.getDni());
			txtRUC.setText("" + x.getRUC());
			
			cboClienteNuevo.setSelectedIndex(x.getClienteNuevo());
		}
	}
	void limpieza() {
		txtCodigo.setText("" + ap.codigoCorrelativo());
		txtNombre.setText("");
		txtDni.setText("");
		txtRUC.setText("");
		cboClienteNuevo.setSelectedIndex(0);
	}
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void habilitarEntradas(boolean sino) {
		btnOK.setEnabled(sino);
		txtNombre.setEditable(sino);
		if (btnModificarDatos.isEnabled() == false)
			txtDni.setEditable(true);
		else
			txtDni.setEditable(sino);
		txtRUC.setEditable(sino);
		cboClienteNuevo.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAgregarCliente.setEnabled(sino);
		btnModificarDatos.setEnabled(sino);
	}
	
	private void cerrarFormularioCliente() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar la ventana?", "Cerrar cong. Cliente",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            dispose(); 
        }
    }
	//   retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}
	String leerRUC() {
		return txtRUC.getText().trim();
	}
	
	int leerPosClienteNuevo() {
		return cboClienteNuevo.getSelectedIndex();
	}
	//  retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	String enTextoClienteNuevo(int i) {
		return cboClienteNuevo.getItemAt(i);
	}
	double ajustar(double numero) {
		return (int)(numero);
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
