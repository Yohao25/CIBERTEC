package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmonto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui5 frame = new Gui5();
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
	public Gui5() {
		setTitle("DINERO A REPARTIR ENTRE HIJOS - ABEL NAVARRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmonto = new JLabel("Monto");
		lblmonto.setBounds(24, 26, 45, 13);
		contentPane.add(lblmonto);
		
		txtmonto = new JTextField();
		txtmonto.setBounds(98, 23, 96, 19);
		contentPane.add(txtmonto);
		txtmonto.setColumns(10);
		
		JScrollPane scpresultado = new JScrollPane();
		scpresultado.setBounds(25, 115, 377, 138);
		contentPane.add(scpresultado);
		
		JTextArea txtresultado = new JTextArea();
		scpresultado.setViewportView(txtresultado);
		
		JButton btncalcular = new JButton("Calcular");
		btncalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declaración de variables
				double monto, tamar, josue, caleb, daniel, david;
				
				//Entrada
				 monto=Double.parseDouble(txtmonto.getText());
				
				//Proceso
				 josue=0.27*monto;
				 tamar=0.85*josue;
				 daniel=0.25*monto;
				 caleb=0.23*(josue+daniel);
				 david= monto-(tamar+josue+caleb+daniel);
				
				//Salida
				txtresultado.setText("----------------------------------------------------------------------\n");
				txtresultado.append("MONTO TOTAL A INVERTIR\n");
				txtresultado.append("-----------------------------------------------------------------------\n");
				txtresultado.append("Lo que recibira Tamar                    : "+tamar+"\n");
				txtresultado.append("Lo que recibira Josue                    : "+josue+"\n");
				txtresultado.append("Lo que recibira Caleb                    : "+caleb+"\n");
				txtresultado.append("Lo que recibira Daniel                   : "+daniel+"\n");
				txtresultado.append("Lo que recibira David                    : "+david+"\n");
				txtresultado.append("----------------------------------------------------------------------\n");
			}
		});
		btncalcular.setBounds(317, 10, 85, 21);
		contentPane.add(btncalcular);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setBounds(317, 51, 85, 21);
		contentPane.add(btnborrar);
		
	}
}
