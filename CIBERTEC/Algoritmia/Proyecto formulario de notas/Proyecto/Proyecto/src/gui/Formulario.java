package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloAlumnos;
import clases.Alumno;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTable tblAlumnos;
	private JTextArea txtReporte;
	private DefaultTableModel modelo;  //crea el modelo de la tabla
	/*private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblNota;
	private JLabel lblNota_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listar();
			}
		});
		btnListar.setBounds(111, 32, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporte();
			}
		});
		btnReportar.setBounds(263, 32, 89, 23);
		contentPane.add(btnReportar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 466, 149);
		contentPane.add(scrollPane);
		
		tblAlumnos = new JTable();
		scrollPane.setViewportView(tblAlumnos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 392, 466, 133);
		contentPane.add(scrollPane_1);
		
		txtReporte = new JTextArea();
		scrollPane_1.setViewportView(txtReporte);
		
		//Dibujando los campos de la tabla Alumnbos
		modelo = new DefaultTableModel();  //instancia de la clase DefaultTableModel
		
		//Agregando las columnas a la tabla		
		modelo.addColumn("Codigo"); 
		modelo.addColumn("Nombre");
		modelo.addColumn("Nota 1");
		modelo.addColumn("Nota 2");
		modelo.addColumn("Promedio");
		
		tblAlumnos.setModel(modelo);  //seteando la tabla agreg�ndole el modelo
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 68, 377, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(21, 34, 46, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(71, 31, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 62, 46, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(71, 59, 276, 20);
		panel.add(txtNombre);
		
		JLabel lblNota = new JLabel("Nota 1");
		lblNota.setBounds(21, 93, 46, 14);
		panel.add(lblNota);
		
		cboNota1 = new JComboBox();
		cboNota1.setBounds(71, 90, 46, 20);
		panel.add(cboNota1);
		
		JLabel lblNota_1 = new JLabel("Nota 2");
		lblNota_1.setBounds(142, 93, 46, 14);
		panel.add(lblNota_1);
		
		cboNota2 = new JComboBox();
		cboNota2.setBounds(192, 90, 46, 20);
		panel.add(cboNota2);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumno nuevoAlumno = llamar();
				aa.agregar(nuevoAlumno);
				listar();
			/*llamar();
			listar();
			cargaNotas();*/
			}
		});
		btnAgregar.setBounds(387, 32, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton = new JButton("Elim. Último");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(387, 64, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Elim. Todo");
		btnNewButton_1.setBounds(387, 95, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Elim. x Cod");
		btnNewButton_2.setBounds(387, 128, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setBounds(391, 159, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Editar");
		btnNewButton_4.setBounds(391, 190, 85, 21);
		contentPane.add(btnNewButton_4);
		
		listar();
		cargaNotas();
	}
	
	ArregloAlumnos aa = new ArregloAlumnos();
	
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox cboNota1;
	private JComboBox cboNota2;
	
	void listar(){
		modelo.setRowCount(0);
		for(int i=0;i<aa.tamaño();i++){
			Object[] fila = {aa.obtener(i).getCodigo(),
					               aa.obtener(i).getNombre(),
					               aa.obtener(i).getNota1(),
					               aa.obtener(i).getNota2(),
					               aa.obtener(i).promedio()};
			
			modelo.addRow(fila);
		}
	}
	
	void reporte(){
		txtReporte.setText(null);
		txtReporte.append("Cantidad de Alumnos:\t "+aa.tamaño()+"\n");
		txtReporte.append("Promedio General:\t "+aa.promedioGeneral());
	}
	
	void cargaNotas(){
		for(int i=0;i<=20;i++)
		{
			cboNota1.addItem(i);
			cboNota2.addItem(i);
		}
		cboNota1.setSelectedIndex(-1);
		cboNota2.setSelectedIndex(-1);
	}
	
	/*int cod,n1,n2;
	String nom;*/
	
	Alumno llamar() {
		int cod,n1,n2;
		String nom;
		
		cod = Integer.parseInt(txtCodigo.getText());
		nom = txtNombre.getText();
	    n1 = cboNota1.getSelectedIndex();
		n2 = cboNota2.getSelectedIndex();
		
		Alumno alumno = new Alumno(cod, nom, n1, n2);
		
		return alumno;
		
	}
}
