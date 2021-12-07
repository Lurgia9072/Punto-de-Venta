import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JButton;

public class Bienvenida extends JFrame {

	private JPanel contentPane;

	

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Bienvenida.class.getResource("/img/bienvenida.png")));
		lblNewLabel.setBounds(29, 85, 553, 520);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACCESO AL");
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("NewsGoth BT", Font.BOLD, 42));
		lblNewLabel_1.setBounds(76, 26, 274, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(" SISTEMA");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("NewsGoth BT", Font.BOLD, 42));
		lblNewLabel_1_1.setBounds(304, 26, 202, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel cargar = new JLabel("");
		cargar.setBounds(415, 689, 161, 24);
		contentPane.add(cargar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 603, 594);
		contentPane.add(panel);
		
		JProgressBar pross = new JProgressBar();
		pross.setStringPainted(true);
		pross.setBounds(39, 626, 484, 42);
		contentPane.add(pross);
		
		//LLAMANDO LA CLASE Avanzando
		
		Avanzando a = new Avanzando();
		a.setBar(pross);
		Thread hilo = new Thread(a);
		hilo.start();
		
		
		
	
	}
	

	class Avanzando implements Runnable
	{
	    JProgressBar bar;
	    
	     int num_bar = 1;
	    
	    @Override
	    public void run() 
	    {
	        for (int i = 1; i <= 100; i++)
	        {      
	            try 
	            {
	                Thread.sleep(100);
	            } 
	            catch (InterruptedException ex) 
	            {
	                Logger.getLogger(Avanzando.class.getName()).log(Level.SEVERE, null, ex);
	            }
	            
	            this.getBar().setValue(i);
	            
	            if (this.getBar().getValue() == 100)
	            {
	                JOptionPane.showMessageDialog(null, "Gracias por la espera: ");
	                 Seguridad s = new Seguridad();
	                 s.setVisible(true);
	                		 
	            }                        
	        }        
	        num_bar++;
	    }

	    public void setBar(JProgressBar bar)
	    {
	        this.bar = bar;
	    }
	    
	    public JProgressBar getBar()
	    {
	        return bar;
	    }
	    
	}
	
}
















