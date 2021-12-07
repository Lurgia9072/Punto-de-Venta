import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cempleado;
import clases.Empleados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Empleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtcod;
	private JTextField txtape;
	private JTextField txt;
	private JTextField txtedad;
	private JTextField txtsexo;
	private JTable miTabla;


	Cempleado ObjNP = new Cempleado();
	DefaultTableModel tabla;
	String Columnas[] = {"CODIGO","APELLIDOS","NOMBRE","EDAD","SEXO"};
	Object Filas[][];
	ArrayList<Empleados> miLista;
	private Component btnModificar;	
	
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
	
	//METODO LIMPIAR CAJAS
		private void LimpiarCajas() {
			txtcod.setText("");
			txtape.setText("");
			txt.setText("");
			txtedad.setText("");
			txtsexo.requestFocus();
			
		}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleado frame = new Empleado();
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
	public Empleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cod Empleado");
		lblNewLabel.setBounds(52, 52, 120, 14);
		contentPane.add(lblNewLabel);
		
		txtcod = new JTextField();
		txtcod.setColumns(10);
		txtcod.setBounds(47, 70, 176, 29);
		contentPane.add(txtcod);
		
		JLabel lblApellidoDeEmpleado = new JLabel("Apellido de Empleado");
		lblApellidoDeEmpleado.setBounds(52, 118, 120, 14);
		contentPane.add(lblApellidoDeEmpleado);
		
		txtape = new JTextField();
		txtape.setColumns(10);
		txtape.setBounds(47, 143, 229, 29);
		contentPane.add(txtape);
		
		JLabel lblNombreDeEmpleado = new JLabel("Nombre de Empleado");
		lblNombreDeEmpleado.setBounds(52, 186, 120, 14);
		contentPane.add(lblNombreDeEmpleado);
		
		txt = new JTextField();
		txt.setColumns(10);
		txt.setBounds(47, 211, 229, 29);
		contentPane.add(txt);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(52, 253, 120, 14);
		contentPane.add(lblEdad);
		
		txtedad = new JTextField();
		txtedad.setColumns(10);
		txtedad.setBounds(47, 278, 229, 29);
		contentPane.add(txtedad);
		
		JLabel lblSexo = new JLabel("sexo");
		lblSexo.setBounds(47, 328, 120, 14);
		contentPane.add(lblSexo);
		
		txtsexo = new JTextField();
		txtsexo.setColumns(10);
		txtsexo.setBounds(47, 349, 229, 29);
		contentPane.add(txtsexo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 51, 484, 356);
		contentPane.add(scrollPane);
		
		miTabla = new JTable();
		miTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int f = miTabla.getSelectedRow();
				txtcod.setText(miTabla.getValueAt(f, 0).toString());
				txtape.setText(miTabla.getValueAt(f, 1).toString());
				txt.setText(miTabla.getValueAt(f, 2).toString());
				txtedad.setText(miTabla.getValueAt(f, 3).toString());
				txtsexo.setText(miTabla.getValueAt(f, 4).toString());
				
			}
		});
		scrollPane.setColumnHeaderView(miTabla);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertar();
				
				
			}
		});
		btnInsertar.setBounds(37, 437, 146, 37);
		contentPane.add(btnInsertar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Modificar();
			}
		});
		btnModificar.setBounds(210, 437, 146, 37);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Eliminar();				
				
			}
		});
		btnEliminar.setBounds(391, 437, 146, 37);
		contentPane.add(btnEliminar);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//boton cerrar
				dispose();
				
			}
		});
		btnCerrar.setBounds(572, 437, 146, 37);
		contentPane.add(btnCerrar);
		
		//MOSTRAR DATOS DE LA TABLA
		CargarTabla();
		
		//generando codigo
		txtcod.setText(ObjNP.GeneraCodigoProducto());
		txtcod.setEnabled(false);
	
	}
	
	
	void insertar() {
		String id=txtcod.getText();
		String des=txtape.getText();
		String pre=txt.getText();
		int sto=Integer.parseInt(txtedad.getText());
		String est=txtsexo.getText();
		
		Empleados ObjP = new Empleados(id,des,pre,sto,est);
		ObjNP.Insertar(ObjP);
		CargarTabla();
		LimpiarCajas();
		JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");


		
	}
	
	void Modificar() {
		
		int fila=miTabla.getSelectedRow();
		
		if(fila==-1){
			
			JOptionPane.showMessageDialog(this, "Debe selecionar una fila");
			btnModificar.setEnabled(false);
		}else {
			Empleados ObjP = new Empleados(txtcod.getText(),
					txtape.getText(),
					txt.getText(),
					Integer.parseInt(txtedad.getText()),
					txtsexo.getText()
					);
			ObjNP.Modificar(ObjP);
			LimpiarCajas();
			CargarTabla();	
			JOptionPane.showMessageDialog(null, "SE MODIFICO EMPELADO");
		}
	}
	void Eliminar() {
		int fila=miTabla.getSelectedRow();
		if(fila==-1){
			JOptionPane.showMessageDialog(this, "Debe selecionar una fila");
		}else{
			ObjNP.Suprimir(txtcod.getText());
			LimpiarCajas();
			CargarTabla();
			JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO CORRECTAMENTE");
		}
	}

}
