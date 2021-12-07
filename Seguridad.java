

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.CSeguridad;
import clases.ConeccionUsuario;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Seguridad extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JComboBox comboBox;

	//llamando la clase de conexion 
	ConeccionUsuario c = new ConeccionUsuario();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seguridad frame = new Seguridad();
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
	public Seguridad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btning = new JButton("INGRESAR");
		btning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ingresar();
			}
		});
		btning.setBounds(24, 364, 379, 50);
		contentPane.add(btning);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(58, 98, 150, 25);
		contentPane.add(lblNewLabel);
		
		pass = new JPasswordField();
		pass.setBounds(46, 242, 347, 50);
		contentPane.add(pass);
		
		JLabel CONTRASEÑA = new JLabel("CONTRASE\u00D1AAAAAA");
		CONTRASEÑA.setBounds(46, 206, 150, 25);
		contentPane.add(CONTRASEÑA);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "User01", "User02 ", "User03"}));
		comboBox.setBounds(24, 134, 383, 61);
		contentPane.add(comboBox);
	}
	
	
	
	
	
	
	
	
	void ingresar() {
		
		CSeguridad ObjV = new CSeguridad();

		String dni=pass.getText();
		String user=comboBox.getSelectedItem().toString();
		
		if(comboBox.getSelectedItem().toString().equals("")|pass.getText().equals("")){
			JOptionPane.showMessageDialog(this, "DebeIngresar datos");
			pass.requestFocus();
		}else{
			ObjV=c.ValidarVendedor( user,dni);
			if(ObjV.getIdUsuario() !=null && ObjV.getContraseña() !=null){
				VentanaPrincipal mp = new VentanaPrincipal();
				mp.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(this, "Debe Ingresar Datos Validos");
				pass.requestFocus();
			}			
		}
	}
}
