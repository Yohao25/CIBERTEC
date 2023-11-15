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

public class Gui4 extends JFrame {

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
					Gui4 frame = new Gui4();
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
	public Gui4() {
		setTitle("MONTO A INVERTIR - ABEL NAVARRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmonto = new JLabel("Monto");
		lblmonto.setBounds(53, 13, 45, 13);
		contentPane.add(lblmonto);
		
		txtmonto = new JTextField();
		txtmonto.setBounds(119, 10, 96, 19);
		contentPane.add(txtmonto);
		txtmonto.setColumns(10);

		JScrollPane scpresultado = new JScrollPane();
		scpresultado.setBounds(40, 110, 364, 143);
		contentPane.add(scpresultado);
		
		JTextArea txtresultado = new JTextArea();
		scpresultado.setViewportView(txtresultado);
		
		JButton btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declaración de variables
				double monto, alqFer, publ, trans, serFer, deco, gasVar;
				
				//Entrada
				monto=Double.parseDouble(txtmonto.getText());
				
				//Proceso
				alqFer=0.23*monto;
				publ=0.7*monto;
				trans=0.26*monto;
				serFer=0.12*monto;
				deco=0.21*monto;
				gasVar=0.11*monto;
				
				//Salida
				txtresultado.setText("----------------------------------------------------------------------\n");
				txtresultado.append("MONTO TOTAL A INVERTIR\n");
				txtresultado.append("-----------------------------------------------------------------------\n");
				txtresultado.append("Alquiler de espacio en la feria    : "+alqFer+"\n");
				txtresultado.append("Publicidad                         : "+publ+"\n");
				txtresultado.append("Transporte                         : "+trans+"\n");
				txtresultado.append("Servicios feriales                 : "+serFer+"\n");
				txtresultado.append("Decoración                         : "+deco+"\n");
				txtresultado.append("Gastos varios                      : "+gasVar+"\n");
				txtresultado.append("----------------------------------------------------------------------\n");				
				
			}
		});
		btnprocesar.setBounds(303, 9, 85, 21);
		contentPane.add(btnprocesar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setBounds(303, 40, 85, 21);
		contentPane.add(btnborrar);
		
	}
}
