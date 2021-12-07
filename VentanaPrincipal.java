import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel VentanaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		
		
		//maximizando
		
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 532);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Empleado");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//GUI Empleado
				Empleado em = new Empleado();
				em.setVisible(true);
				
				//centrar(em);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Consultas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Apellidos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//GUI Apellidos 
				Apellidos a = new Apellidos();
				a.setVisible(true);
				//centrar(a);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("IdEmpleado");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//GUI IdEmpleado
				IdEmpleado em = new IdEmpleado();
				em.setVisible(true);
				//centrar(em);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Edad");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//GUI Edad
				Edad em = new Edad();
				em.setVisible(true);
				//centrar(em);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Salir");
		menuBar.add(mnNewMenu_2);
		VentanaPrincipal = new JPanel();
		VentanaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VentanaPrincipal);
		VentanaPrincipal.setLayout(null);
		
	}
	
	
	
	
	//centrar a los guis
	void centrar(JInternalFrame frame) {
		VentanaPrincipal.add(frame);
		Dimension dimensio = VentanaPrincipal.getSize();
		Dimension ventanas = frame.getSize();
		frame.setLocation((dimensio.width - ventanas.width)/2,(dimensio.height - ventanas.height)/2);
	}
	}
