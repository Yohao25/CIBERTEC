package Form;

import Clase.CR_Productos;
import Clase.Compartido;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class R_Productos extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JLabel lblNewLabel;
	private JComboBox<Object> cboCat;
	private JComboBox<Object> cboSubCat;
	private JLabel lblNewLabel_1;
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
					R_Productos frame = new R_Productos();
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
	
	String Nom,Cat,SCa;
	
	public R_Productos() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 451, 520);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 11, 155, 20);
		getContentPane().add(txtNombre);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 14, 97, 14);
		getContentPane().add(lblNewLabel);
		
		cboCat = new JComboBox<Object>();
		cboCat.addActionListener(this);
		cboCat.setBounds(117, 35, 155, 22);
		getContentPane().add(cboCat);
		
		cboSubCat = new JComboBox<Object>();
		cboSubCat.setBounds(117, 62, 155, 22);
		getContentPane().add(cboSubCat);
		
		lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 39, 97, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Sub-Categoria");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 66, 97, 14);
		getContentPane().add(lblNewLabel_2);
		
		BtnNuevo = new JButton("Nuevo");
		BtnNuevo.addActionListener(this);
		BtnNuevo.setBounds(313, 11, 110, 23);
		getContentPane().add(BtnNuevo);
		
		BtnGrabar = new JButton("Grabar");
		BtnGrabar.addActionListener(this);
		BtnGrabar.setBounds(313, 39, 110, 68);
		getContentPane().add(BtnGrabar);
		
		BtnCancelar = new JButton("Cancelar");
		BtnCancelar.addActionListener(this);
		BtnCancelar.setBounds(313, 113, 110, 23);
		getContentPane().add(BtnCancelar);
		
		BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(this);
		BtnSalir.setBounds(313, 141, 110, 33);
		getContentPane().add(BtnSalir);
		
		textArea = new JTextArea();
		textArea.setBounds(11, 186, 412, 291);
		getContentPane().add(textArea);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\D-ICONS\\imagenes\\PRODUCTOS 3.png"));
		lblNewLabel_3.setBounds(10, 84, 110, 112);
		getContentPane().add(lblNewLabel_3);
		
		cboCat.addItem("Video");
		cboCat.addItem("Ram");
		BtnCancelar.doClick();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCat) {
			do_cboCat_actionPerformed(e);
		}
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
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,true);
		Comparte.HabilitaCombo(cboCat,true);
		Comparte.HabilitaCombo(cboSubCat,true);
		Comparte.HabilitaBotones_Nuevo(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		txtNombre.requestFocus();
		SeleccionCombo();
	}
	
	protected void do_BtnGrabar_actionPerformed(ActionEvent e) {
		Nom = txtNombre.getText();
		Cat = (String) cboCat.getSelectedItem();
		SCa = (String) cboSubCat.getSelectedItem();
		CR_Productos CR_Productos = new CR_Productos(Nom,Cat,SCa);
		CR_Productos.Imprime(textArea);
	}
	
	protected void do_BtnCancelar_actionPerformed(ActionEvent e) {
		Compartido Comparte = new Compartido(Nom);
		Comparte.Borrar(txtNombre);
		Comparte.BorrarCombo(cboCat,"Video");
		Comparte.Imprime_Borrar(textArea);
		Comparte.HabilitaTexto(txtNombre,false);
		Comparte.HabilitaCombo(cboCat,false);
		Comparte.HabilitaCombo(cboSubCat,false);
		Comparte.HabilitaBotones_Cancelar(BtnNuevo, BtnGrabar, BtnCancelar, BtnSalir);
		SeleccionCombo();
	}
	
	protected void do_BtnSalir_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
    public void SeleccionCombo() {
		String Valor =  (String) cboCat.getSelectedItem();
    	//--------------------------------------
    	switch (Valor) {
		case "Video":
			cboSubCat.removeAllItems();
			cboSubCat.addItem("DDR5");
			cboSubCat.addItem("DDR6");
			cboSubCat.addItem("DDR6 Low Profile");
			break;
		case "Ram":
			cboSubCat.removeAllItems();
			cboSubCat.addItem("Ram DDR2");
			cboSubCat.addItem("Ram DDR3");
			cboSubCat.addItem("Ram DDR4");
			cboSubCat.addItem("Ram DDR5");
			break;
		default:
		}
    	//--------------------------------------
    }
	protected void do_cboCat_actionPerformed(ActionEvent e) {
		SeleccionCombo();
	}
	public void keyPressed(KeyEvent e) {
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
		if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c) || Character.isDigit(c) ) {
			txtNombre.setEditable(true);
		} else {
			txtNombre.setEditable(false);
		}
	}
}
