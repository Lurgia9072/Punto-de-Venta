import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cempleado;
import clases.Empleados;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edad extends JFrame {

	private JPanel contentPane;
	private JTextField txtcod;
	private JTextField txtape;
	private JTextField txtnom;
	private JTextField txtedad;
	private JTextField txtsexo;
	private JTable miTabla;

	
	
	
	Cempleado ObjNP = new Cempleado();
	DefaultTableModel tabla;
	String Columnas[] = {"CODIGO","APELLIDOS","NOMBRE","EDAD","SEXO"};
	Object Filas[][];
	ArrayList<Empleados> miLista;
	
	
	
	private void CargarTabla() {
		tabla = new DefaultTableModel();
		miLista = new ArrayList<Empleados>();
		miLista = ObjNP.Listar();
		Filas = new Object[miLista.size()][5];
		for(int i = 0; i < Columnas.length; i++)tabla.addColumn(Columnas[i]);
		for(int i = 0; i < miLista.size(); i++) {
			Filas[i][0] = miLista.get(i).getCod();
			Filas[i][1] = miLista.get(i).getApellidos();
			Filas[i][2] = miLista.get(i).getNombres();
			Filas[i][3] = miLista.get(i).getEdad();
			Filas[i][4] = miLista.get(i).getSexo();
			tabla.addRow(Filas[i]);
		}
		miTabla.setModel(tabla);

		
	}
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edad frame = new Edad();
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
	public Edad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcod = new JTextField();
		txtcod.setColumns(10);
		txtcod.setBounds(69, 82, 144, 20);
		contentPane.add(txtcod);
		
		JLabel lblNewLabel = new JLabel("COD");
		lblNewLabel.setBounds(79, 65, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APELLIDO");
		lblNewLabel_1.setBounds(79, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtape = new JTextField();
		txtape.setColumns(10);
		txtape.setBounds(74, 133, 181, 20);
		contentPane.add(txtape);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(84, 164, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(79, 188, 176, 23);
		contentPane.add(txtnom);
		
		JLabel lblNewLabel_3 = new JLabel("EDAD");
		lblNewLabel_3.setBounds(89, 222, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtedad = new JTextField();
		txtedad.setColumns(10);
		txtedad.setBounds(83, 244, 172, 20);
		contentPane.add(txtedad);
		
		JLabel lblNewLabel_4 = new JLabel("SEXO");
		lblNewLabel_4.setBounds(92, 11, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtsexo = new JTextField();
		txtsexo.setColumns(10);
		txtsexo.setBounds(69, 36, 86, 20);
		contentPane.add(txtsexo);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Empleados ObjP = new Empleados();
				ObjP = ObjNP.BuscarEdad(Integer.parseInt(txtedad.getText()));

				if(ObjP !=null){
					txtcod.setText(ObjP.getCod());
					txtape.setText(ObjP.getApellidos());
					txtnom.setText(ObjP.getNombres()+"");
					txtedad.setText(ObjP.getApellidos()+"");
					txtsexo.setText(ObjP.getEdad()+"");	
					
				}else{
					JOptionPane.showMessageDialog(null, "ERROR, CODIGO CLIENTE NO EXISTE");
				}
				
				
			
				
			}
		});
		btnbuscar.setBounds(288, 27, 89, 23);
		contentPane.add(btnbuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 275, 583, 266);
		contentPane.add(scrollPane);
		
		miTabla = new JTable();
		scrollPane.setColumnHeaderView(miTabla);
		CargarTabla();
	}

}
