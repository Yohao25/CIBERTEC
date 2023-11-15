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
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Gui3 extends JFrame {

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
					Gui3 frame = new Gui3();
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
	public Gui3() {
		setTitle("MONTO DE DONACIÓN - ABEL NAVARRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmonto = new JLabel("Monto");
		lblmonto.setBounds(41, 32, 45, 13);
		contentPane.add(lblmonto);
		
		txtmonto = new JTextField();
		txtmonto.setBounds(113, 29, 96, 19);
		contentPane.add(txtmonto);
		txtmonto.setColumns(10);
		
		JScrollPane scpresultado = new JScrollPane();
		scpresultado.setBounds(41, 90, 329, 149);
		contentPane.add(scpresultado);
		
		JTextArea txtresultado = new JTextArea();
		scpresultado.setViewportView(txtresultado);
		
		JButton btncalcular = new JButton("Calcular");
		btncalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declaración de variables
				double monto,cenSal,posMed,escuela,comedor,asiAnc;
				
				//Entrada
				monto=Double.parseDouble(txtmonto.getText());
				
				//Proceso
				cenSal=0.25*monto;
				escuela=0.35*monto;
				comedor=0.28*(escuela+cenSal);
				posMed=0.4*comedor;
				asiAnc=monto-(cenSal+escuela+comedor+posMed);
				
				//Salida
				txtresultado.setText("----------------------------------------------------------------------\n");
				txtresultado.append("MONTO TOTAL DE DONACIÓN A REPARTIR\n");
				txtresultado.append("-----------------------------------------------------------------------\n");
				txtresultado.append("Centro de Salud....: "+cenSal+"\n");
				txtresultado.append("Posta Médica.......: "+posMed+"\n");
				txtresultado.append("Escuela............: "+escuela+"\n");
				txtresultado.append("Comedor............: "+comedor+"\n");
				txtresultado.append("Asilo de ancianos..: "+asiAnc+"\n");
				txtresultado.append("----------------------------------------------------------------------\n");				
			}
		});
		btncalcular.setBounds(268, 28, 85, 21);
		contentPane.add(btncalcular);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setBounds(268, 59, 85, 21);
		contentPane.add(btnborrar);
		
	}

}