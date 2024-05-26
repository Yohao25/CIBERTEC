package Form;

import Clase.CR_Proveedores;
import Clase.Compartido;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class R_Proveedores extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JButton BtnNuevo;
	private JTextField txtNombre;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtRSocial;
	private JButton BtnGrabar;
	private JTextField txtRuc;
	private JLabel lblNewLabel_2;
	private JButton BtnCancelar;
	private JButton BtnSalir;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_3;
	private JLabel lblTelefono;
	private JTextField txtTelef;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JTextArea textArea;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					R_Proveedores frame = new R_Proveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	String Nom, RSo, Ruc, Cor, Tel, Dir;
	
	public R_Proveedores() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setBounds(100, 100, 554, 581);
		getContentPane().setLayout(null);
		
		BtnNuevo = new JButton("Nuevo");
		BtnNuevo.addActionListener(this);
		BtnNuevo.setBounds(423, 11, 110, 23);
		getContentPane().add(BtnNuevo);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 11, 155, 20);
		getContentPane().add(txtNombre);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 97, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Razon Social");
		lblNewLabel_1.setBounds(10, 38, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtRSocial = new JTextField();
		txtRSocial.addKeyListener(this);
		txtRSocial.setColumns(10);
		txtRSocial.setBounds(117, 35, 155, 20);
		getContentPane().add(txtRSocial);
		
		BtnGrabar = new JButton("Grabar");
		BtnGrabar.addActionListener(this);
		BtnGrabar.setBounds(423, 39, 110, 68);
		getContentPane().add(BtnGrabar);
		
		txtRuc = new JTextField();
		txtRuc.addKeyListener(this);
		txtRuc.setColumns(10);
		txtRuc.setBounds(117, 59, 155, 20);
		getContentPane().add(txtRuc);
		
		lblNewLabel_2 = new JLabel("RUC");
		lblNewLabel_2.setBounds(10, 62, 97, 14);
		getContentPane().add(lblNewLabel_2);
		
		BtnCancelar = new JButton("Cancelar");
		BtnCancelar.addActionListener(this);
		BtnCancelar.setBounds(423, 113, 110, 23);
		getContentPane().add(BtnCancelar);
		
		BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(this);
		BtnSalir.setBounds(423, 141, 110, 33);
		getContentPane().add(BtnSalir);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(117, 83, 155, 20);
		getContentPane().add(txtCorreo);
		
		lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(10, 86, 97, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 110, 97, 14);
		getContentPane().add(lblTelefono);
		
		txtTelef = new JTextField();
		txtTelef.addKeyListener(this);
		txtTelef.setColumns(10);
		txtTelef.setBounds(117, 107, 155, 20);
		getContentPane().add(txtTelef);
		
		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(this);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(117, 131, 155, 20);
		getContentPane().add(txtDireccion);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 134, 97, 14);
		getContentPane().add(lblDireccion);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 180, 523, 362);
		getContentPane().add(textArea);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\D-ICONS\\imagenes\\PROVEEDORES.png"));
		lblNewLabel_4.setBounds(303, 22, 110, 129);
		getContentPane().add(lblNewLabel_4);
		
		BtnCancelar.doClick();
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
		Comparte.Borrar(txtNombre);
		Comparte.Borrar(txtRSocial);
		Comparte.Borrar(txtRuc);
		Comparte.Borrar(txtCorreo);
		Comparte.Borrar(txtTelef);
		Comparte.Borrar(txtDireccion);
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,true);
		Comparte.HabilitaTexto(txtRSocial,true);
		Comparte.HabilitaTexto(txtRuc,true);
		Comparte.HabilitaTexto(txtCorreo,true);
		Comparte.HabilitaTexto(txtTelef,true);
		Comparte.HabilitaTexto(txtDireccion,true);
		Comparte.HabilitaBotones_Nuevo(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		txtNombre.requestFocus();
	}
	protected void do_BtnGrabar_actionPerformed(ActionEvent e) {
		Nom = txtNombre.getText();
		RSo = txtRSocial.getText();
		Ruc = txtRuc.getText();
		Cor = txtCorreo.getText();
		Tel = txtTelef.getText();
		Dir = txtDireccion.getText();
		CR_Proveedores CR_Proveedores = new CR_Proveedores(Nom, RSo, Ruc, Cor, Tel, Dir);
		CR_Proveedores.Imprime(textArea);
	}
	protected void do_BtnCancelar_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.Borrar(txtNombre);
		Comparte.Borrar(txtRSocial);
		Comparte.Borrar(txtRuc);
		Comparte.Borrar(txtCorreo);
		Comparte.Borrar(txtTelef);
		Comparte.Borrar(txtDireccion);
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,false);
		Comparte.HabilitaTexto(txtRSocial,false);
		Comparte.HabilitaTexto(txtRuc,false);
		Comparte.HabilitaTexto(txtCorreo,false);
		Comparte.HabilitaTexto(txtTelef,false);
		Comparte.HabilitaTexto(txtDireccion,false);
		Comparte.HabilitaBotones_Cancelar(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
	}
	protected void do_BtnSalir_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.HabilitaBotones_Cancelar(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		this.dispose();
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtDireccion) {
			do_txtDireccion_keyPressed(e);
		}
		if (e.getSource() == txtTelef) {
			do_txtTelef_keyPressed(e);
		}
		if (e.getSource() == txtRuc) {
			do_txtRuc_keyPressed(e);
		}
		if (e.getSource() == txtRSocial) {
			do_txtRSocial_keyPressed(e);
		}
		if (e.getSource() == txtNombre) {
			do_txtNombre_keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void do_txtNombre_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
			txtNombre.setEditable(true);
		} else {
			txtNombre.setEditable(false);
		}
	}
	protected void do_txtRSocial_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
			txtRSocial.setEditable(true);
		} else {
			txtRSocial.setEditable(false);
		}
	}
	protected void do_txtRuc_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isDigit(c) || Character.isISOControl(c)) {
			txtRuc.setEditable(true);
		} else {
			txtRuc.setEditable(false);
		}
	}
	protected void do_txtTelef_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isDigit(c) || Character.isISOControl(c)) {
			txtTelef.setEditable(true);
		} else {
			txtTelef.setEditable(false);
		}
	}
	protected void do_txtDireccion_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c) || Character.isDigit(c) ) {
			txtDireccion.setEditable(true);
		} else {
			txtDireccion.setEditable(false);
		}
	}
}
