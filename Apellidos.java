import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Cempleado;
import clases.Empleados;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Apellidos extends JFrame {

	private JPanel contentPane;
	private JTextField txtsexo;
	private JTextField txtedad;
	private JTextField txtnom;
	private JTextField txtape;
	private JTextField txtcod;
	private JTable miTabla ;
	
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
					Apellidos frame = new Apellidos();
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
	public Apellidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 275, 583, 266);
		contentPane.add(scrollPane);
		
		JTable miTabla = new JTable();
		scrollPane.setColumnHeaderView(miTabla);
		
		txtsexo = new JTextField();
		txtsexo.setColumns(10);
		txtsexo.setBounds(92, 244, 86, 20);
		contentPane.add(txtsexo);
		
		JLabel lblNewLabel_4 = new JLabel("SEXO");
		lblNewLabel_4.setBounds(115, 219, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtedad = new JTextField();
		txtedad.setColumns(10);
		txtedad.setBounds(92, 190, 172, 20);
		contentPane.add(txtedad);
		
		JLabel lblNewLabel_3 = new JLabel("EDAD");
		lblNewLabel_3.setBounds(98, 168, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(88, 134, 176, 23);
		contentPane.add(txtnom);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(93, 110, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtape = new JTextField();
		txtape.setColumns(10);
		txtape.setBounds(83, 79, 181, 20);
		contentPane.add(txtape);
		
		JLabel lblNewLabel_1 = new JLabel("APELLIDO");
		lblNewLabel_1.setBounds(88, 54, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtcod = new JTextField();
		txtcod.setColumns(10);
		txtcod.setBounds(78, 28, 144, 20);
		contentPane.add(txtcod);
		
		JLabel lblNewLabel = new JLabel("COD");
		lblNewLabel.setBounds(88, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Empleados ObjP = new Empleados();
				ObjP = ObjNP.BuscarApellido(txtape.getText());

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
		btnbuscar.setBounds(260, 27, 89, 23);
		contentPane.add(btnbuscar);
	
		CargarTabla();
		
	}
	

}
