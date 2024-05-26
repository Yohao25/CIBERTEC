package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.SwingConstants;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
//import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;

public class I_Inicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsu;
	private JButton btnIngresar;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					I_Inicio frame = new I_Inicio();
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
	String usu,pas;
	private JPasswordField txtPas;
	private JLabel lblNewLabel_2;
		
    public void CenteredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY); 
    } 
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	public I_Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\D-ICONS\\16 x 16\\lock.png"));
		setBackground(SystemColor.desktop);
		setTitle("Iniciar sesion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 225);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CenteredFrame(this);
		//centreWindow(this);
		
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(157, 62, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(157, 87, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(242, 60, 133, 20);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnIngresar.setIcon(new ImageIcon("C:\\D-ICONS\\110-iconos\\apply.ico"));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(400, 38, 90, 63);
		contentPane.add(btnIngresar);
		
		btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\D-ICONS\\16 x 16\\cancel.png"));
		btnNewButton_1.setBounds(400, 111, 88, 43);
		contentPane.add(btnNewButton_1);
		
		txtPas = new JPasswordField();
		txtPas.setBounds(242, 85, 133, 20);
		contentPane.add(txtPas);
		//setFocusTraversalKeysEnabled(new FocusTraversalOnArray(new Component[]{txtUsu, txtPas, btnIngresar, btnNewButton_1}));	
		
		txtUsu.setText("admin");
		txtPas.setText("admin");
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\D-ICONS\\imagenes\\LOGIN.png"));
		lblNewLabel_2.setBounds(10, -15, 150, 190);
		contentPane.add(lblNewLabel_2);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		//----------------------------
		usu = txtUsu.getText();
		char[]clave=txtPas.getPassword();
		pas = new String(clave);
		//----------------------------
		if (usu.equals("admin") && pas.equals("admin")) {
			dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema: "+usu+"","INGRESASTE",JOptionPane.INFORMATION_MESSAGE);
			I_Menu p = new I_Menu();
			p.setVisible(true);	
			//this.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña INCORRECTA","ERROR",JOptionPane.ERROR_MESSAGE);
			txtUsu.setText("");
			txtPas.setText("");
			txtUsu.requestFocus();
		}
		
	}	
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
