package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reporte extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtS;
	private JComboBox cboproducto;
	private JButton btnconsultar;
	private JButton btngrabar;
	private JButton btncancelar;
	private JButton btnsalir;
	private JLabel lblcantidad;
	private JSpinner spncantidad;
	private JLabel lblproducto;
	private JComboBox cboproduto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte frame = new Reporte();
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
	public Reporte() {
		setTitle("REPORTES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtS = new JTextArea();
		txtS.setBounds(23, 211, 548, 346);
		contentPane.add(txtS);
		
		cboproducto = new JComboBox();
		contentPane.add(cboproducto);
		
		cboproducto.addItem("MSI RTX 4060 8gb");
		cboproducto.addItem("Asus RTX 4080ti 16gb");
		cboproducto.addItem("Asus RTX 4050 4gb");
		
		 btnconsultar = new JButton("Consultar");
		 btnconsultar.addActionListener(this);
		btnconsultar.setBounds(450, 34, 85, 21);
		contentPane.add(btnconsultar);
		
		 btngrabar = new JButton("Grabar");
		 btnconsultar.addActionListener(this);
		btngrabar.setBounds(450, 65, 85, 36);
		contentPane.add(btngrabar);
		
		 btncancelar = new JButton("Cancelar");
		 btnconsultar.addActionListener(this);
		btncancelar.setBounds(450, 111, 85, 21);
		contentPane.add(btncancelar);
		
		 btnsalir = new JButton("Salir");
		 btnconsultar.addActionListener(this);
		btnsalir.setBounds(450, 142, 85, 21);
		contentPane.add(btnsalir);
		
		 lblcantidad = new JLabel("Cantidad");
		lblcantidad.setBounds(68, 77, 45, 13);
		contentPane.add(lblcantidad);
		
		 spncantidad = new JSpinner();
		spncantidad.setBounds(174, 74, 73, 20);
		contentPane.add(spncantidad);
		
		lblproducto = new JLabel("Producto");
		lblproducto.setBounds(68, 38, 45, 13);
		contentPane.add(lblproducto);
		
		cboproducto = new JComboBox();
		cboproducto.setBounds(123, 34, 124, 21);
		contentPane.add(cboproducto);
		cboproducto.addItem("MSI RTX 4060 8gb");
		cboproducto.addItem("Asus RTX 4080ti 16gb");
		cboproducto.addItem("Asus RTX 4050 4gb");
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
