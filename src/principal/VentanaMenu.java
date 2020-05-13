package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Menu Principal");
		this.setLocationRelativeTo(null);
		
		JLabel lblOperacionesConFracciones = new JLabel("OPERACIONES CON FRACCIONES");
		lblOperacionesConFracciones.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOperacionesConFracciones.setBounds(64, 23, 367, 24);
		contentPane.add(lblOperacionesConFracciones);
		
		JButton btnSuma = new JButton("SUMA");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaModelo("suma");
				
			}
		});
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSuma.setBounds(49, 79, 148, 48);
		contentPane.add(btnSuma);
		
		JButton btnResta = new JButton("RESTA");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaModelo("resta");
				
			}
		});
		btnResta.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResta.setBounds(266, 79, 148, 48);
		contentPane.add(btnResta);
		
		JButton btnMultiplicacion = new JButton("MULTIPLICACION");
		btnMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaModelo("multiplicacion");
			}
		});
		btnMultiplicacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMultiplicacion.setBounds(49, 192, 148, 48);
		contentPane.add(btnMultiplicacion);
		
		JButton btnDivision = new JButton("DIVISION");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaModelo("division");
			}
		});
		btnDivision.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDivision.setBounds(266, 192, 148, 48);
		contentPane.add(btnDivision);
	}
}
