package ADS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class solicitud extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					solicitud frame = new solicitud();
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
	public solicitud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(186, 31, 212, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("RUC/C\u00F3digo");
		lblNewLabel.setBounds(57, 36, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre o Raz\u00F3n socilal ");
		lblNewLabel_1.setBounds(57, 83, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 78, 212, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(229, 148, 314, 25);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(229, 247, 212, 25);
		contentPane.add(textField_4);
		
		lblNewLabel_2 = new JLabel("Documento de envio al OSCE ");
		lblNewLabel_2.setBounds(57, 153, 162, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Fecha de documento ");
		lblNewLabel_3.setBounds(57, 200, 151, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Observaciones ");
		lblNewLabel_4.setBounds(57, 252, 151, 14);
		contentPane.add(lblNewLabel_4);
		
		Choice choice = new Choice();
		choice.setBounds(229, 205, 184, 20);
		contentPane.add(choice);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(170, 316, 116, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBorrador = new JButton("Cancelar");
		btnBorrador.setBounds(296, 316, 116, 31);
		contentPane.add(btnBorrador);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 559, 115);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 137, 559, 160);
		contentPane.add(panel_1);
	}
}
