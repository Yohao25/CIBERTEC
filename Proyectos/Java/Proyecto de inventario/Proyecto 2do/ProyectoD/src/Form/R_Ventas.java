package Form;

import Clase.CR_Ventas;
import Clase.Compartido;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class R_Ventas extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<Object> cboProductos;
	private JLabel lblProductos;
	private JTextField txtPrecio;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JSpinner spCantidad;
	private JComboBox<Object> cboCliente;
	private JLabel lblNewLabel_2;
	private JButton BtnNuevo;
	private JButton BtnGrabar;
	private JButton BtnCancelar;
	private JButton BtnSalir;
	private JTextArea textArea;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					R_Ventas frame = new R_Ventas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String Nom,Cli;
	Integer Can;
	Double Pre;
	
	public R_Ventas() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setBounds(100, 100, 546, 602);
		getContentPane().setLayout(null);
		
		cboProductos = new JComboBox<Object>();
		cboProductos.setBounds(117, 11, 205, 22);
		getContentPane().add(cboProductos);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setBounds(10, 14, 97, 14);
		getContentPane().add(lblProductos);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(117, 37, 65, 20);
		getContentPane().add(txtPrecio);
		
		lblNewLabel = new JLabel("Precio");
		lblNewLabel.setBounds(10, 40, 97, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10, 64, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		spCantidad = new JSpinner();
		spCantidad.setBounds(117, 61, 65, 20);
		getContentPane().add(spCantidad);
		
		cboCliente = new JComboBox<Object>();
		cboCliente.setBounds(117, 85, 155, 22);
		getContentPane().add(cboCliente);
		
		lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(10, 89, 97, 14);
		getContentPane().add(lblNewLabel_2);
		
		BtnNuevo = new JButton("Nuevo");
		BtnNuevo.addActionListener(this);
		BtnNuevo.setBounds(411, 11, 110, 23);
		getContentPane().add(BtnNuevo);
		
		BtnGrabar = new JButton("Grabar");
		BtnGrabar.addActionListener(this);
		BtnGrabar.setBounds(411, 39, 110, 68);
		getContentPane().add(BtnGrabar);
		
		BtnCancelar = new JButton("Cancelar");
		BtnCancelar.addActionListener(this);
		BtnCancelar.setBounds(411, 113, 110, 23);
		getContentPane().add(BtnCancelar);
		
		BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(this);
		BtnSalir.setBounds(411, 141, 110, 33);
		getContentPane().add(BtnSalir);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 185, 511, 379);
		getContentPane().add(textArea);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\D-ICONS\\imagenes\\VENTAS.png"));
		lblNewLabel_3.setBounds(273, 34, 126, 124);
		getContentPane().add(lblNewLabel_3);
		
		//--------------------------------------------
		cboProductos.addItem("MSI RTX 4060 8gb");
		cboProductos.addItem("Asus RTX 4080ti 16gb");
		cboProductos.addItem("Asus RTX 4050 4gb");
		//--------------------------------------------
		cboCliente.addItem("Sergio Mubarak");
		cboCliente.addItem("Angela Ventura");
		BtnCancelar.doClick();
		//--------------------------------------------
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtnSalir) {
			do_BtnSalir_actionPerformed(e);
		}
		if (e.getSource() == BtnCancelar) {
			do_BtnCancelar_actionPerformed(e);
		}
		if (e.getSource() == BtnGrabar) {
			do_BtnGrabar_actionPerformed(e);
		}
		if (e.getSource() == BtnNuevo) {
			do_BtnNuevo_actionPerformed(e);
		}
	}
	protected void do_BtnNuevo_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.Borrar(txtPrecio);
		Comparte.BorrarSPinner(spCantidad);
		Comparte.BorrarCombo(cboProductos,"MSI RTX 4060 8gb");
		Comparte.BorrarCombo(cboCliente,"Sergio Mubarak");
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtPrecio,true);
		Comparte.HabilitaCombo(cboProductos, true);
		Comparte.HabilitaCombo(cboCliente, true);
		Comparte.HabilitaSpinner(spCantidad,true);
		Comparte.HabilitaBotones_Nuevo(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		cboProductos.requestFocus();
	}
	protected void do_BtnGrabar_actionPerformed(ActionEvent e) {
		Nom = (String) cboProductos.getSelectedItem();
		Pre = Double.parseDouble(txtPrecio.getText());
		Can = (Integer) spCantidad.getValue();
		Cli = (String) cboCliente.getSelectedItem();
		CR_Ventas CR_Ventas = new CR_Ventas(Nom,Pre,Can,Cli);
		CR_Ventas.Imprime(textArea);
	}
	protected void do_BtnCancelar_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.Borrar(txtPrecio);
		Comparte.BorrarSPinner(spCantidad);
		Comparte.BorrarCombo(cboProductos,"MSI RTX 4060 8gb");
		Comparte.BorrarCombo(cboCliente,"Sergio Mubarak");
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtPrecio,false);
		Comparte.HabilitaCombo(cboProductos, false);
		Comparte.HabilitaCombo(cboCliente, false);
		Comparte.HabilitaSpinner(spCantidad,false);
		Comparte.HabilitaBotones_Cancelar(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
	}
	protected void do_BtnSalir_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.HabilitaBotones_Cancelar(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		this.dispose();
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtPrecio) {
			do_txtPrecio_keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void do_txtPrecio_keyPressed(KeyEvent e) {
	}
}
