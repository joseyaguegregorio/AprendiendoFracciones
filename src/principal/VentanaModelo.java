package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class VentanaModelo extends JFrame {

	private JPanel contentPane;
	private JTextField numeradorResultado;
	private JTextField denominadorResultado;
	HashMap<String, Object> ejercicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModelo frame = new VentanaModelo();
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
	public VentanaModelo() {

		setTitle("Suma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel numerador1 = new JLabel("1");
		numerador1.setFont(new Font("Dialog", Font.PLAIN, 37));
		numerador1.setHorizontalAlignment(SwingConstants.CENTER);
		numerador1.setBounds(53, 70, 69, 56);
		contentPane.add(numerador1);

		JLabel numerador2 = new JLabel("6");
		numerador2.setHorizontalAlignment(SwingConstants.CENTER);
		numerador2.setFont(new Font("Dialog", Font.PLAIN, 37));
		numerador2.setBounds(179, 70, 69, 56);
		contentPane.add(numerador2);

		JLabel separador1 = new JLabel("___");
		separador1.setHorizontalAlignment(SwingConstants.CENTER);
		separador1.setFont(new Font("Dialog", Font.PLAIN, 37));
		separador1.setBounds(39, 99, 98, 39);
		contentPane.add(separador1);

		JLabel separador2 = new JLabel("___");
		separador2.setHorizontalAlignment(SwingConstants.CENTER);
		separador2.setFont(new Font("Dialog", Font.PLAIN, 37));
		separador2.setBounds(165, 99, 98, 39);
		contentPane.add(separador2);

		JLabel denominador1 = new JLabel("3");
		denominador1.setHorizontalAlignment(SwingConstants.CENTER);
		denominador1.setFont(new Font("Dialog", Font.PLAIN, 37));
		denominador1.setBounds(53, 150, 69, 56);
		contentPane.add(denominador1);

		JLabel denominador2 = new JLabel("8");
		denominador2.setHorizontalAlignment(SwingConstants.CENTER);
		denominador2.setFont(new Font("Dialog", Font.PLAIN, 37));
		denominador2.setBounds(179, 150, 69, 56);
		contentPane.add(denominador2);

		JLabel simboloOperacion = new JLabel("+");
		simboloOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		simboloOperacion.setFont(new Font("Dialog", Font.PLAIN, 37));
		simboloOperacion.setBounds(117, 108, 69, 56);
		contentPane.add(simboloOperacion);

		JLabel simboloIgual = new JLabel("=");
		simboloIgual.setHorizontalAlignment(SwingConstants.CENTER);
		simboloIgual.setFont(new Font("Dialog", Font.PLAIN, 37));
		simboloIgual.setBounds(249, 108, 69, 56);
		contentPane.add(simboloIgual);

		JLabel separador3 = new JLabel("___");
		separador3.setHorizontalAlignment(SwingConstants.CENTER);
		separador3.setFont(new Font("Dialog", Font.PLAIN, 37));
		separador3.setBounds(307, 99, 98, 39);
		contentPane.add(separador3);

		numeradorResultado = new JTextField();
		numeradorResultado.setText("1");
		numeradorResultado.setHorizontalAlignment(SwingConstants.CENTER);
		numeradorResultado.setFont(new Font("Dialog", Font.PLAIN, 37));
		numeradorResultado.setBounds(318, 70, 74, 56);
		contentPane.add(numeradorResultado);
		numeradorResultado.setColumns(10);

		denominadorResultado = new JTextField();
		denominadorResultado.setHorizontalAlignment(SwingConstants.CENTER);
		denominadorResultado.setText("2");
		denominadorResultado.setFont(new Font("Dialog", Font.PLAIN, 37));
		denominadorResultado.setColumns(10);
		denominadorResultado.setBounds(317, 150, 74, 56);
		contentPane.add(denominadorResultado);

		ejercicio = CalculosMatematicos.crearEjercicio("suma", "facil");

		numerador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getNumerador() + "");
		numerador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getNumerador() + "");
		denominador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getDenominador() + "");
		denominador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getDenominador() + "");
		simboloOperacion.setText(((String) (ejercicio.get("signo"))));
		//Faltaria la parte de marco 
		numeradorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getNumerador() + "");
		denominadorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getNumerador() + "");
		
		

		JButton botonNuevoEjercicio = new JButton("Siguiente");
		botonNuevoEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejercicio = CalculosMatematicos.crearEjercicio("suma", "facil");
				numerador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getNumerador() + "");
				numerador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getNumerador() + "");
				denominador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getDenominador() + "");
				denominador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getDenominador() + "");
				simboloOperacion.setText((String)ejercicio.get("signo"));
				numeradorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getNumerador() + "");
				denominadorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getDenominador() + "");

			}
		});
		botonNuevoEjercicio.setBounds(360, 233, 84, 39);
		contentPane.add(botonNuevoEjercicio);
	}
}
