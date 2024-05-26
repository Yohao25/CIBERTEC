package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_Inventario extends JFrame {
	private JComboBox cboproducto;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblproducto;
	private JComboBox cboalmacen;
	private JLabel lblalmacen;
	private JButton btnsalir;
	private JTextArea txtS;
	private JButton btnconsultar;
	private JButton btngrabar;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_Inventario frame = new M_Inventario();
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
	public M_Inventario() {
	    setTitle("INVENTARIO INICIAL");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 604, 602);
	    contentPane = new JPanel();
	    contentPane.setBackground(new Color(176, 196, 222));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(38, 216, 516, 306);
	    contentPane.add(scrollPane);
	    
	    txtS = new JTextArea();
	    scrollPane.setViewportView(txtS);
	    
	    btnconsultar = new JButton("Consultar");
	    btnconsultar.setBounds(421, 28, 85, 21);
	    contentPane.add(btnconsultar);
	    
	    btngrabar = new JButton("Grabar"); // Asegúrate de que esta es la instancia que deseas utilizar
	    btngrabar.setBounds(421, 59, 85, 48);
	    contentPane.add(btngrabar);
	    btngrabar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Aquí va la lógica que se ejecutará cuando se haga clic en "Grabar"
	            System.out.println("Grabar seleccionado");
	        }
	    });
	    
	    btnsalir = new JButton("Salir");
	    btnsalir.setBounds(421, 117, 85, 21);
	    contentPane.add(btnsalir);
	    
	    lblalmacen = new JLabel("Almacen");
	    lblalmacen.setBounds(22, 32, 64, 13);
	    contentPane.add(lblalmacen);
	    
	    cboalmacen = new JComboBox<Object>();
	    cboalmacen.setBounds(113, 28, 122, 21);
	    contentPane.add(cboalmacen);
	    
	    lblproducto = new JLabel("Producto");
	    lblproducto.setBounds(22, 63, 45, 13);
	    contentPane.add(lblproducto);
	    
	    cboproducto = new JComboBox<Object>();
	    cboproducto.setBounds(113, 59, 122, 21);
	    contentPane.add(cboproducto);
	    
	    cboproducto.addItem("MSI RTX 4060 8gb");
	    cboproducto.addItem("Asus RTX 4080ti 16gb");
	    cboproducto.addItem("Asus RTX 4050 4gb");
	    
	    // Elimina la creación de btnNewButton si no es necesario
	

	}

	public void setFrameIcon(Icon icon) {
		// TODO Auto-generated method stub
		
	}
	}
		/*JButton btngrabar = new JButton("Grabar");
		btngrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
			
			
			}
		});
		
	}

	public void setFrameIcon(Icon icon) {
		// TODO Auto-generated method stub
		
	}
	

}
*/