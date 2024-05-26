package Form;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Clase.CR_Clientes;
import Clase.Compartido;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class R_Clientes extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblDireccion;
	private JLabel lblNewLabel_3;
	private JButton BtnNuevo;
	private JButton BtnGrabar;
	private JButton BtnCancelar;
	private JButton BtnSalir;
	private JTextArea textArea;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					R_Clientes frame = new R_Clientes();
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
	
	String Nom,Ape,Dir,Tel,Cor;
	
	public R_Clientes() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setBounds(100, 100, 557, 561);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 97, 14);
		getContentPane().add(lblNewLabel);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(111, 103, 155, 20);
		getContentPane().add(txtCorreo);
		
		lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(10, 37, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(10, 60, 97, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 83, 97, 14);
		getContentPane().add(lblDireccion);
		
		lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(10, 106, 97, 14);
		getContentPane().add(lblNewLabel_3);
		
		BtnNuevo = new JButton("Nuevo");
		BtnNuevo.addActionListener(this);
		BtnNuevo.setBounds(422, 11, 110, 23);
		getContentPane().add(BtnNuevo);
		
		BtnGrabar = new JButton("Grabar");
		BtnGrabar.addActionListener(this);
		BtnGrabar.setBounds(422, 39, 110, 68);
		getContentPane().add(BtnGrabar);
		
		BtnCancelar = new JButton("Cancelar");
		BtnCancelar.addActionListener(this);
		BtnCancelar.setBounds(422, 113, 110, 23);
		getContentPane().add(BtnCancelar);
		
		BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(this);
		BtnSalir.setBounds(422, 141, 110, 33);
		getContentPane().add(BtnSalir);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 185, 522, 336);
		getContentPane().add(textArea);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(111, 11, 155, 20);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(this);
		txtApellido.setColumns(10);
		txtApellido.setBounds(111, 34, 155, 20);
		getContentPane().add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(111, 57, 155, 20);
		getContentPane().add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(this);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(111, 80, 155, 20);
		getContentPane().add(txtDireccion);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\D-ICONS\\imagenes\\CLIENTE.png"));
		lblNewLabel_4.setBounds(270, 14, 155, 160);
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
		Comparte.Borrar(txtApellido);
		Comparte.Borrar(txtDireccion);
		Comparte.Borrar(txtTelefono);
		Comparte.Borrar(txtCorreo);
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,true);
		Comparte.HabilitaTexto(txtApellido,true);
		Comparte.HabilitaTexto(txtDireccion,true);
		Comparte.HabilitaTexto(txtTelefono,true);
		Comparte.HabilitaTexto(txtCorreo,true);
		Comparte.HabilitaBotones_Nuevo(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		txtNombre.requestFocus();
	}
	protected void do_BtnGrabar_actionPerformed(ActionEvent e) {
		Nom = txtNombre.getText();
		Ape = txtApellido.getText();
		Dir = txtDireccion.getText();
		Tel = txtTelefono.getText();
		Cor = txtCorreo.getText();
		CR_Clientes CR_Clientes = new CR_Clientes(Nom,Ape,Tel,Dir,Cor);
		CR_Clientes.Imprime(textArea);
	}
	protected void do_BtnCancelar_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.Borrar(txtNombre);
		Comparte.Borrar(txtApellido);
		Comparte.Borrar(txtDireccion);
		Comparte.Borrar(txtTelefono);
		Comparte.Borrar(txtCorreo);
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,false);
		Comparte.HabilitaTexto(txtApellido,false);
		Comparte.HabilitaTexto(txtDireccion,false);
		Comparte.HabilitaTexto(txtTelefono,false);
		Comparte.HabilitaTexto(txtCorreo,false);
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
		if (e.getSource() == txtTelefono) {
			do_txtTelefono_keyPressed(e);
		}
		if (e.getSource() == txtApellido) {
			do_txtApellido_keyPressed(e);
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
	protected void do_txtApellido_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
			txtApellido.setEditable(true);
		} else {
			txtApellido.setEditable(false);
		}
	}
	protected void do_txtTelefono_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isDigit(c) || Character.isISOControl(c)) {
			txtTelefono.setEditable(true);
		} else {
			txtTelefono.setEditable(false);
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
