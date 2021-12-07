package Consultas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Cempleado;
import clases.Empleados;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Consultas extends JFrame {

	private JPanel contentPane;
	private JTextField buscar;
	private JScrollPane scrollPane_1;
	private Component btnModificar;	
	private JTable miTabla;

	Cempleado ObjNP = new Cempleado();
	DefaultTableModel tabla;
	String Columnas[] = {"CODIGO","APELLIDOS","NOMBRE","EDAD","SEXO"};
	Object Filas[][];
	ArrayList<Empleados> miLista;
	//filtarr
	
	TableRowSorter<DefaultTableModel> sorter;
	
	
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
		miTabla.setAutoCreateRowSorter(true);
		sorter = new TableRowSorter<>(tabla);
		miTabla.setRowSorter(sorter);
	}
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultas frame = new Consultas();
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
	public Consultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		buscar = new JTextField();
		buscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				filtar();
				
			}
		}); 
		buscar.setColumns(10);
		buscar.setBounds(152, 424, 229, 29);
		contentPane.add(buscar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(92, 29, 595, 371);
		contentPane.add(scrollPane_1);
		
		miTabla = new JTable();
		scrollPane_1.setColumnHeaderView(miTabla);
		
		CargarTabla();
	}
	
		
	void filtar() {
		String dato=String.valueOf(tabla.getValueAt(miTabla.getSelectedRow(),0));
		try {
			sorter.setRowFilter(RowFilter.regexFilter(buscar.getText()));
			
		} catch (Exception e) {
			System.out.println("no se puede buscar" + e.getLocalizedMessage());
		}
	}
}
