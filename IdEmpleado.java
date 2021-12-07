import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Cempleado;
import clases.Empleados;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class IdEmpleado extends JFrame {

	private JPanel contentPane;
	private JTable miTabla;
	private JTextField txtcod;



	private JTextField txtape;
	private JTextField txtnom;
	private JTextField txtedad;
	private JTextField txtsexo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
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
					IdEmpleado frame = new IdEmpleado();
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
	public IdEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 289, 583, 266);
		contentPane.add(scrollPane);
		
		miTabla = new JTable();
		scrollPane.setColumnHeaderView(miTabla);
		
		txtcod = new JTextField();
		txtcod.setBounds(57, 42, 144, 20);
		contentPane.add(txtcod);
		txtcod.setColumns(10);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Empleados ObjP = new Empleados();
				ObjP = ObjNP.Buscar(txtcod.getText());

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
		btnbuscar.setBounds(239, 41, 89, 23);
		contentPane.add(btnbuscar);
		
		txtape = new JTextField();
		txtape.setBounds(62, 93, 181, 20);
		contentPane.add(txtape);
		txtape.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setBounds(67, 148, 176, 23);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		txtedad = new JTextField();
		txtedad.setBounds(71, 204, 172, 20);
		contentPane.add(txtedad);
		txtedad.setColumns(10);
		
		txtsexo = new JTextField();
		txtsexo.setBounds(71, 258, 86, 20);
		contentPane.add(txtsexo);
		txtsexo.setColumns(10);
		
		lblNewLabel = new JLabel("COD");
		lblNewLabel.setBounds(67, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("APELLIDO");
		lblNewLabel_1.setBounds(67, 68, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(72, 124, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("EDAD");
		lblNewLabel_3.setBounds(77, 182, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("SEXO");
		lblNewLabel_4.setBounds(94, 233, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		CargarTabla();
	}

}
