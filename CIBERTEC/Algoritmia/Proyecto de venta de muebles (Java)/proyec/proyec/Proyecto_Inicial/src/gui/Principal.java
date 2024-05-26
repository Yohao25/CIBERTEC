package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import gui.Productos;
import datos.BaseDeDatosProductos;
import datos.BaseDeDatosVentas;
import modelo.ConsultarProducto;
import javax.swing.*;
import java.awt.*;
import gui.VentasRealizadas;
import gui.GenerarReportes;

public class Principal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
	
    
      private JMenuItem mnSalir;
      private JMenuItem mnConsultarProductos;
      private JMenuItem mnclientes;
      private JMenuItem mnVender;
      private JMenuItem mnAcercaDeTienda;
      
      private JDesktopPane dpPrincipal;
      private JTextField textField;
   
  

      public static void main(String[] args) {
          EventQueue.invokeLater(() -> {
              try {
                  Principal frame = new Principal();
                  frame.setVisible(true);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          });
      }

    public Principal() {
    	getContentPane().setBackground(new Color(153, 153, 153));
    	setBackground(new Color(0, 51, 153));
        setSize(800, 600); // para Establecer un tamaño predeterminado
        diseñaGUI();
    
    }

    void diseñaGUI() {
        setTitle("TOTTUS - Venta de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 700);

        dpPrincipal = new JDesktopPane();
        dpPrincipal.setBackground(new Color(255, 255, 204));
        //getContentPane().add(dpPrincipal, BorderLayout.SOUTH);
        setContentPane(dpPrincipal);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(102, 204, 204));
        setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        mnArchivo.setIcon(new ImageIcon(Principal.class.getResource("/iconos/action_exit_close_remove_13915.png")));
        menuBar.add(mnArchivo);

        JMenu mnMantenimiento = new JMenu("Mantenimiento");
        mnMantenimiento.setIcon(new ImageIcon(Principal.class.getResource("/iconos/3668839-gear-maintenance-service-technical_108029 (1).png")));
        menuBar.add(mnMantenimiento);

        JMenu mnVentas = new JMenu("Ventas");
        mnVentas.setIcon(new ImageIcon(Principal.class.getResource("/iconos/sell_stock-48_46556 (1).png")));
        menuBar.add(mnVentas);

        JMenu mnAyuda = new JMenu("Reportes");
        mnAyuda.setIcon(new ImageIcon(Principal.class.getResource("/iconos/business_man_user_support_supportfortheuser_aquestion_theclient_2330.png")));
        menuBar.add(mnAyuda);

        mnSalir = new JMenuItem("Salir");
        mnSalir.setIcon(new ImageIcon(Principal.class.getResource("/iconos/SignOut_icon-icons.com_74704.png")));
        mnSalir.addActionListener(this);
        mnArchivo.add(mnSalir);

        mnConsultarProductos = new JMenuItem(" Productos");
        mnConsultarProductos.setIcon(new ImageIcon(Principal.class.getResource("/iconos/iconfinder-check-listnotepadseo-and-webcheck-marklistinglistedoffice-materialschool-material-4394750_119517 (1).png")));
        //mnConsultarProductos.addActionListener(this);
        mnConsultarProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  Productos formInterno2 = new Productos();
            	  dpPrincipal.add(formInterno2);
                  formInterno2.setVisible(true);

            }
        });
        mnMantenimiento.add(mnConsultarProductos);

        mnclientes = new JMenuItem("Clientes");
        mnclientes.setIcon(new ImageIcon(Principal.class.getResource("/iconos/generatetables_ok_home_out_edit_generar_1491 (1).png")));
        mnclientes.addActionListener(this);
      //mnConsultarClientes.addActionListener(this);
        mnclientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  Cliente formInterno3 = new Cliente();
            	  dpPrincipal.add(formInterno3);
                  formInterno3.setVisible(true);

            }
        });
        
        mnMantenimiento.add(mnclientes);

        mnVender = new JMenuItem("Vender");
        mnVender.setIcon(new ImageIcon(Principal.class.getResource("/iconos/sell_stock-48_46556 (1).png")));
        mnVender.addActionListener(this);
        mnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  Vender formInterno4 = new Vender();
            	  dpPrincipal.add(formInterno4);
                  formInterno4.setVisible(true);

            }
        });
        mnVentas.add(mnVender);

        mnAcercaDeTienda = new JMenuItem("Ventas realizadas");
        mnAcercaDeTienda.setIcon(new ImageIcon(Principal.class.getResource("/iconos/shop_106574.png")));
        mnAcercaDeTienda.addActionListener(this);
        mnAcercaDeTienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentasRealizadas formInterno5 = new VentasRealizadas();
            	  dpPrincipal.add(formInterno5);
                  formInterno5.setVisible(true);

            }
        });
        
        mnAyuda.add(mnAcercaDeTienda);
        
        textField = new JTextField();
        menuBar.add(textField);
        textField.setColumns(10);

       
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


 
}
