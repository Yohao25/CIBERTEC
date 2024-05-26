package Form;

import Clase.CR_Almacen;
import Clase.Compartido;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;


public class R_Almacen extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JButton BtnGrabar;
	private JButton BtnNuevo;
	private JButton BtnCancelar;
	private JButton BtnSalir;
	private JLabel lblNewLabel_4;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					R_Almacen frame = new R_Almacen();
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
	
	String Nom,Dir,Tel,Cor;
	
	public R_Almacen() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Registro de Almacen");
		setBounds(100, 100, 420, 540);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 11, 155, 20);
		getContentPane().add(txtNombre);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 97, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Direccion");
		lblNewLabel_1.setBounds(10, 37, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(10, 60, 97, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(10, 83, 97, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(this);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(117, 34, 155, 20);
		getContentPane().add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(117, 57, 155, 20);
		getContentPane().add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(117, 80, 155, 20);
		getContentPane().add(txtCorreo);
		
		BtnGrabar = new JButton("Grabar");
		BtnGrabar.addActionListener(this);
		BtnGrabar.setBounds(282, 39, 110, 68);
		getContentPane().add(BtnGrabar);
		
		BtnNuevo = new JButton("Nuevo");
		BtnNuevo.addActionListener(this);
		BtnNuevo.setBounds(282, 11, 110, 23);
		getContentPane().add(BtnNuevo);
		
		BtnCancelar = new JButton("Cancelar");
		BtnCancelar.addActionListener(this);
		BtnCancelar.setBounds(282, 113, 110, 23);
		getContentPane().add(BtnCancelar);
		
		BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(this);
		BtnSalir.setBounds(282, 141, 110, 33);
		getContentPane().add(BtnSalir);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\D-ICONS\\imagenes\\ALMACE.png"));
		lblNewLabel_4.setBounds(10, 106, 85, 78);
		getContentPane().add(lblNewLabel_4);
		
		textArea = new JTextArea();
		textArea.setBounds(11, 185, 383, 315);
		getContentPane().add(textArea);
		
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
		Comparte.Borrar(txtDireccion);
		Comparte.Borrar(txtTelefono);
		Comparte.Borrar(txtCorreo);
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,true);
		Comparte.HabilitaTexto(txtDireccion,true);
		Comparte.HabilitaTexto(txtTelefono,true);
		Comparte.HabilitaTexto(txtCorreo,true);
		Comparte.HabilitaBotones_Nuevo(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		txtNombre.requestFocus();
	}
	protected void do_BtnGrabar_actionPerformed(ActionEvent e) {
		Nom = txtNombre.getText();
		Dir = txtDireccion.getText();
		Tel = txtTelefono.getText();
		Cor = txtCorreo.getText();
		CR_Almacen CR_Almacen = new CR_Almacen(Nom,Dir,Tel,Cor);
		CR_Almacen.Imprime(textArea);
	}
	protected void do_BtnCancelar_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.Borrar(txtNombre);
		Comparte.Borrar(txtDireccion);
		Comparte.Borrar(txtTelefono);
		Comparte.Borrar(txtCorreo);
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,false);
		Comparte.HabilitaTexto(txtDireccion,false);
		Comparte.HabilitaTexto(txtTelefono,false);
		Comparte.HabilitaTexto(txtCorreo,false);
		Comparte.HabilitaBotones_Cancelar(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
	}
	protected void do_BtnSalir_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtTelefono) {
			do_txtTelefono_keyPressed(e);
		}
		if (e.getSource() == txtDireccion) {
			do_txtDireccion_keyPressed(e);
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
	protected void do_txtDireccion_keyPressed(KeyEvent e) {
		char c  = e.getKeyChar();
		if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c) || Character.isDigit(c) ) {
			txtDireccion.setEditable(true);
		} else {
			txtDireccion.setEditable(false);
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
}
