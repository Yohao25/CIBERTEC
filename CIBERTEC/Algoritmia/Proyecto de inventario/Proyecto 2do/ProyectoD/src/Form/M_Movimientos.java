package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class M_Movimientos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS; 
	private JButton btnconsultar; 
	private JButton btngrabar;
	private JComboBox cboproductos;
	private JLabel lblproductos;
	private JButton btnsalir; 
	private JComboBox cboalmacen;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_Movimientos frame = new M_Movimientos();
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
	public M_Movimientos() {
		setTitle("MOVIMIENTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 229, 527, 316);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnconsultar = new JButton("Consultar");
		btnconsultar.addActionListener(this);
		btnconsultar.setBounds(431, 27, 85, 21);
		contentPane.add(btnconsultar);
		
		btnsalir = new JButton("Salir");
		btnsalir.addActionListener(this);
		btnsalir.setBounds(431, 128, 85, 21);
		contentPane.add(btnsalir);
		
		btngrabar = new JButton("Grabar");
		btngrabar.addActionListener(this);
		btngrabar.setBounds(431, 58, 85, 60);
		contentPane.add(btngrabar);
		btngrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		lblproductos = new JLabel("Productos");
		lblproductos.setBounds(44, 31, 85, 13);
		contentPane.add(lblproductos);
		
		cboproductos = new JComboBox();
		cboproductos.setBounds(121, 27, 140, 21);
		contentPane.add(cboproductos);
		
		cboproductos.addItem("MSI RTX 4060 8gb");
		cboproductos.addItem("Asus RTX 4080ti 16gb");
		cboproductos.addItem("Asus RTX 4050 4gb");
		
		
		
		JLabel lblalmacen = new JLabel("Almacen");
		lblalmacen.setBounds(48, 82, 63, 13);
		contentPane.add(lblalmacen);
		
		cboalmacen = new JComboBox();
		cboalmacen.setBounds(121, 78, 140, 21);
		contentPane.add(cboalmacen);
	}
	

public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btnconsultar) {
	    do_btnconsultar_actionPerformed(e);
	}
	if (e.getSource() == btngrabar) {
	    do_btngrabar_actionPerformed(e);
	}
	if (e.getSource() == btnsalir) {
	    do_btnsalir_actionPerformed(e);
	}

	
}


private void do_btnsalir_actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

private void do_btngrabar_actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

private void do_btnconsultar_actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

public void setFrameIcon(Icon icon) {
	// TODO Auto-generated method stub
	
}

}
