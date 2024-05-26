package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class I_Menu extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane dpMenu;
	private JMenuBar menuBar;
	private JMenu mn_Inicio;
	private JMenuItem mn_ICerrarSesion;
	private JMenuItem mn_ISalir;
	private JMenu mn_Registros;
	private JMenuItem mn_RAlmacen;
	private JMenuItem mn_RCliente;
	private JMenuItem mn_RProductos;
	private JMenuItem mn_RProveedores;
	private JMenuItem mn_RVentas;
	private JMenu mn_Movimientos;
	private JMenuItem mn_MInvInicial;
	private JMenuItem mn_MMovStock;
	private JMenu mn_Reportes;
	private JMenuItem mn_ReAlmacen;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					I_Menu frame = new I_Menu();
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
	
	protected void SalirSistema() {	
		int option = JOptionPane.showConfirmDialog(
				null, 
				"¿Desea salir del sistema?",
				"Sistema", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				System.exit(0);
		}	
	}
	
	public I_Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\D-ICONS\\110-iconos-2\\key.ico"));
		addWindowListener(this);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 882, 648);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.YELLOW);
		setJMenuBar(menuBar);
		
		mn_Inicio = new JMenu("INICIO");
		menuBar.add(mn_Inicio);
		
		mn_ICerrarSesion = new JMenuItem("Cerrar Sesion");
		mn_ICerrarSesion.setIcon(new ImageIcon("C:\\D-ICONS\\302-iconos\\user_drop16_h.ico"));
		mn_ICerrarSesion.addActionListener(this);
		mn_Inicio.add(mn_ICerrarSesion);
		
		mn_ISalir = new JMenuItem("Salir");
		mn_ISalir.setIcon(new ImageIcon("C:\\D-ICONS\\164-iconos-16-16-formato-ico\\exit.ico"));
		mn_ISalir.addActionListener(this);
		mn_Inicio.add(mn_ISalir);
		
		mn_Registros = new JMenu("REGISTROS");
		menuBar.add(mn_Registros);
		
		mn_RAlmacen = new JMenuItem("Almacenes");
		mn_RAlmacen.setIcon(new ImageIcon("C:\\D-ICONS\\110-iconos-2\\home.ico"));
		mn_RAlmacen.addActionListener(this);
		mn_Registros.add(mn_RAlmacen);
		
		mn_RCliente = new JMenuItem("Clientes");
		mn_RCliente.setIcon(new ImageIcon("C:\\D-ICONS\\110-iconos-2\\adim.ico"));
		mn_RCliente.addActionListener(this);
		mn_Registros.add(mn_RCliente);
		
		mn_RProductos = new JMenuItem("Productos");
		mn_RProductos.setSelectedIcon(new ImageIcon("C:\\D-ICONS\\110-iconos-2\\objects.ico"));
		mn_RProductos.setIcon(new ImageIcon("C:\\D-ICONS\\110-iconos-2\\objects.ico"));
		mn_RProductos.addActionListener(this);
		mn_Registros.add(mn_RProductos);
		
		mn_RProveedores = new JMenuItem("Proveedores");
		mn_RProveedores.addActionListener(this);
		mn_RProveedores.setIcon(new ImageIcon("C:\\D-ICONS\\110-iconos-2\\shopping cart.ico"));
		mn_Registros.add(mn_RProveedores);
		
		mn_RVentas = new JMenuItem("Ventas");
		mn_RVentas.setIcon(new ImageIcon("C:\\D-ICONS\\110-iconos-2\\pack.ico"));
		mn_RVentas.addActionListener(this);
		mn_Registros.add(mn_RVentas);
		
		mn_Movimientos = new JMenu("MOVIMIENTOS");
		menuBar.add(mn_Movimientos);
		
		mn_MInvInicial = new JMenuItem("Inventario Inicial");
		mn_MInvInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        M_Inventario Frm = new M_Inventario();
		        Dimension desktopSize = dpMenu.getSize();
		        Dimension FrameSize = Frm.getSize();
		        Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
		        dpMenu.add(Frm);
		        Frm.setFrameIcon(mn_MInvInicial.getIcon());
		        Frm.setTitle(mn_MInvInicial.getText());
		        Frm.setVisible(true);
		    }
		});
		mn_Movimientos.add(mn_MInvInicial);
		
		mn_MMovStock = new JMenuItem("Movimientos de Stock");
		mn_MMovStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        M_Movimientos Frm = new M_Movimientos();
		        Dimension desktopSize = dpMenu.getSize();
		        Dimension FrameSize = Frm.getSize();
		        Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
		        dpMenu.add(Frm);
		        Frm.setFrameIcon(mn_MMovStock.getIcon());
		        Frm.setTitle(mn_MMovStock.getText());
		        Frm.setVisible(true);
		    }
		});
		mn_Movimientos.add(mn_MMovStock);
		
		mn_Reportes = new JMenu("REPORTES");
		menuBar.add(mn_Reportes);
		
		mn_ReAlmacen = new JMenuItem("Reporte Almacen");
		mn_ReAlmacen.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        R_Almacen Frm = new R_Almacen();
			        Dimension desktopSize = dpMenu.getSize();
			        Dimension FrameSize = Frm.getSize();
			        Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
			        dpMenu.add(Frm);
			        Frm.setFrameIcon(mn_ReAlmacen.getIcon());
			        Frm.setTitle(mn_ReAlmacen.getText());
			        Frm.setVisible(true);
			    }
		});
		mn_Reportes.add(mn_ReAlmacen);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		dpMenu = new JDesktopPane();
		dpMenu.setBackground(Color.DARK_GRAY);
		contentPane.add(dpMenu, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mn_RProveedores) {
			do_mn_RProveedores_actionPerformed(e);
		}
		if (e.getSource() == mn_RVentas) {
			do_mn_RVentas_actionPerformed(e);
		}
		if (e.getSource() == mn_RProductos) {
			do_mn_RProductos_actionPerformed(e);
		}
		if (e.getSource() == mn_RCliente) {
			do_mn_RCliente_actionPerformed(e);
		}
		if (e.getSource() == mn_ISalir) {
			do_mn_ISalir_actionPerformed(e);
		}
		if (e.getSource() == mn_ICerrarSesion) {
			do_mn_ICerrarSesion_actionPerformed(e);
		}
		if (e.getSource() == mn_RAlmacen) {
			do_mn_RAlmacen_actionPerformed(e);
		}
		if (e.getSource() == mn_MInvInicial) {
			do_mn_RAlmacen_actionPerformed(e);
		}
		if (e.getSource() == mn_MMovStock) {
			do_mn_RAlmacen_actionPerformed(e);
		}
		if (e.getSource() == mn_ReAlmacen) {
			do_mn_RAlmacen_actionPerformed(e);
		}
	}
	protected void do_mn_RAlmacen_actionPerformed(ActionEvent e) {
		R_Almacen Frm = new R_Almacen();
		Dimension desktopSize = dpMenu.getSize();
		Dimension FrameSize = Frm.getSize();
		Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
		dpMenu.add(Frm);
		Frm.setTitle(this.getTitle());
		Frm.setVisible(true);
	}
	protected void do_mn_ICerrarSesion_actionPerformed(ActionEvent e) {
		String Botones[] = {"Si","No"};
		int eleccion = JOptionPane.showOptionDialog(this, "¿Cerrar sesion?", "Sistema", 0, 0, null, Botones, JOptionPane.QUESTION_MESSAGE);
		
		if (eleccion==JOptionPane.YES_OPTION) {
			dispose();
			I_Inicio p = new I_Inicio();
			p.setVisible(true);	
		} else if(eleccion==JOptionPane.NO_OPTION) {
			System.out.println("Se cerro la sesion");
		}
	}
	protected void do_mn_ISalir_actionPerformed(ActionEvent e) {
		SalirSistema();
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == this) {
			do_this_windowClosing(e);
		}
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
	protected void do_this_windowClosing(WindowEvent e) {
		SalirSistema();
	}
	protected void do_mn_RCliente_actionPerformed(ActionEvent e) {
		R_Clientes Frm = new R_Clientes();
		Dimension desktopSize = dpMenu.getSize();
		Dimension FrameSize = Frm.getSize();
		Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
		dpMenu.add(Frm);
		Frm.setFrameIcon(mn_RCliente.getIcon());
		Frm.setTitle(mn_RCliente.getText());
		Frm.setVisible(true);
	}
	protected void do_mn_RProductos_actionPerformed(ActionEvent e) {
		R_Productos Frm = new R_Productos();
		Dimension desktopSize = dpMenu.getSize();
		Dimension FrameSize = Frm.getSize();
		Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
		dpMenu.add(Frm);
		Frm.setFrameIcon(mn_RProductos.getIcon());
		Frm.setTitle(mn_RProductos.getText());
		Frm.setVisible(true);
	}
	protected void do_mn_RVentas_actionPerformed(ActionEvent e) {
		R_Ventas Frm = new R_Ventas();
		Dimension desktopSize = dpMenu.getSize();
		Dimension FrameSize = Frm.getSize();
		Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
		dpMenu.add(Frm);
		Frm.setFrameIcon(mn_RVentas.getIcon());
		Frm.setTitle(mn_RVentas.getText());
		Frm.setVisible(true);
	}
	protected void do_mn_RProveedores_actionPerformed(ActionEvent e) {
		R_Proveedores Frm = new R_Proveedores();
		Dimension desktopSize = dpMenu.getSize();
		Dimension FrameSize = Frm.getSize();
		Frm.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
		dpMenu.add(Frm);
		Frm.setFrameIcon(mn_RProveedores.getIcon());
		Frm.setTitle(mn_RProveedores.getText());
		Frm.setVisible(true);
	}
}
