package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

	JPanel contentPane;
	JTextField numeradorResultado = new JTextField("");
	JTextField denominadorResultado = new JTextField("");
	HashMap<String, Object> ejercicio;
	JLabel numerador1 = new JLabel("1");
	JLabel numerador2 = new JLabel("6");
	JLabel separador1 = new JLabel("___");
	JLabel separador2 = new JLabel("___");
	JLabel denominador1 = new JLabel("3");
	JLabel denominador2 = new JLabel("8");
	JLabel simboloOperacion = new JLabel("+");
	JLabel simboloIgual = new JLabel("=");
	JLabel separador3 = new JLabel("___");
	JButton botonResultado = new JButton("Resultado");
	JLabel labelResultado = new JLabel("Resultado");
	Fraccion fracccionResultado;
	boolean vistaResultado = false;
	String tipo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaModelo frame = new VentanaModelo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaModelo(String tipo) {
		this.tipo = tipo;
		setVisible(true);
		setTitle(tipo);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 315);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		numerador1.setFont(new Font("Dialog", Font.PLAIN, 37));
		numerador1.setHorizontalAlignment(SwingConstants.CENTER);
		numerador1.setBounds(53, 70, 69, 56);
		contentPane.add(numerador1);
		numerador2.setHorizontalAlignment(SwingConstants.CENTER);
		numerador2.setFont(new Font("Dialog", Font.PLAIN, 37));
		numerador2.setBounds(179, 70, 69, 56);
		contentPane.add(numerador2);
		separador1.setHorizontalAlignment(SwingConstants.CENTER);
		separador1.setFont(new Font("Dialog", Font.PLAIN, 37));
		separador1.setBounds(39, 99, 98, 39);
		contentPane.add(separador1);
		separador2.setHorizontalAlignment(SwingConstants.CENTER);
		separador2.setFont(new Font("Dialog", Font.PLAIN, 37));
		separador2.setBounds(165, 99, 98, 39);
		contentPane.add(separador2);
		denominador1.setHorizontalAlignment(SwingConstants.CENTER);
		denominador1.setFont(new Font("Dialog", Font.PLAIN, 37));
		denominador1.setBounds(53, 150, 69, 56);
		contentPane.add(denominador1);
		denominador2.setHorizontalAlignment(SwingConstants.CENTER);
		denominador2.setFont(new Font("Dialog", Font.PLAIN, 37));
		denominador2.setBounds(179, 150, 69, 56);
		contentPane.add(denominador2);
		simboloOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		simboloOperacion.setFont(new Font("Dialog", Font.PLAIN, 37));
		simboloOperacion.setBounds(117, 108, 69, 56);
		contentPane.add(simboloOperacion);
		simboloIgual.setHorizontalAlignment(SwingConstants.CENTER);
		simboloIgual.setFont(new Font("Dialog", Font.PLAIN, 37));
		simboloIgual.setBounds(249, 108, 69, 56);
		contentPane.add(simboloIgual);
		separador3.setHorizontalAlignment(SwingConstants.CENTER);
		separador3.setFont(new Font("Dialog", Font.PLAIN, 37));
		separador3.setBounds(307, 99, 98, 39);
		contentPane.add(separador3);
		numeradorResultado.setText("");
		numeradorResultado.setHorizontalAlignment(SwingConstants.CENTER);
		numeradorResultado.setFont(new Font("Dialog", Font.PLAIN, 37));
		numeradorResultado.setBounds(318, 70, 74, 56);
		contentPane.add(numeradorResultado);
		numeradorResultado.setColumns(10);
		denominadorResultado.setHorizontalAlignment(SwingConstants.CENTER);
		denominadorResultado.setText("");
		denominadorResultado.setFont(new Font("Dialog", Font.PLAIN, 37));
		denominadorResultado.setColumns(10);
		denominadorResultado.setBounds(317, 150, 74, 56);
		contentPane.add(denominadorResultado);
		botonResultado.setBounds(360, 233, 84, 39);
		contentPane.add(botonResultado);
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setVerticalAlignment(SwingConstants.TOP);
		labelResultado.setBounds(30, 70, 402, 158);
		contentPane.add(labelResultado);
		labelResultado.setVisible(false);

//Creacion primer del ejercicio		

		ejercicio = CalculosMatematicos.crearEjercicio(tipo, "facil");
		numerador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getNumerador() + "");
		numerador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getNumerador() + "");
		denominador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getDenominador() + "");
		denominador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getDenominador() + "");
		simboloOperacion.setText(((String) (ejercicio.get("signo"))));
//Si quereis hacer test aqui los resultados en interfaz
//		numeradorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getNumerador() + "");
//		denominadorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getDenominador() + "");

		setTitle(((String) (ejercicio.get("tipo"))));
		fracccionResultado = (Fraccion) ejercicio.get("resultado");

		botonResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (vistaResultado) {
						mostrarEjercicio();
					} else {
						mostrarResultado();

					}

				} catch (Exception e2) {
					System.out.println("Debe de introducir un valor correcto, propongo otro ejercicio");
					mostrarEjercicio();
				}

			}
		});

	}

	public void ocultarElementos() {
		numerador1.setVisible(false);
		numerador2.setVisible(false);
		numeradorResultado.setVisible(false);
		denominador1.setVisible(false);
		denominador2.setVisible(false);
		denominadorResultado.setVisible(false);
		simboloOperacion.setVisible(false);
		separador1.setVisible(false);
		separador2.setVisible(false);
		separador3.setVisible(false);
		simboloIgual.setVisible(false);

	}

	public void mostrarElementos() {
		numerador1.setVisible(true);
		numerador2.setVisible(true);
		numeradorResultado.setVisible(true);
		denominador1.setVisible(true);
		denominador2.setVisible(true);
		denominadorResultado.setVisible(true);
		simboloOperacion.setVisible(true);
		separador1.setVisible(true);
		separador2.setVisible(true);
		separador3.setVisible(true);
		simboloIgual.setVisible(true);
	}

	public void mostrarResultado() {

		ocultarElementos();
		labelResultado.setVisible(true);
		botonResultado.setText("Siguiente");
		if (CalculosMatematicos.sonIguales(fracccionResultado, numeradorResultado.getText(),
				denominadorResultado.getText())) {
			labelResultado.setText("Correcto!");
		} else {
			labelResultado.setText("Incorrecto, el resultado es \n" + fracccionResultado.getNumerador() + "/"
					+ fracccionResultado.getDenominador());
		}
		vistaResultado = true;

	}

	public void mostrarEjercicio() {

		labelResultado.setVisible(false);
		botonResultado.setText("Resultado");
		ejercicio = CalculosMatematicos.crearEjercicio(tipo, "facil");

		numerador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getNumerador() + "");
		numerador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getNumerador() + "");
		denominador1.setText(((Fraccion) (ejercicio.get("fraccionA"))).getDenominador() + "");
		denominador2.setText(((Fraccion) (ejercicio.get("fraccionB"))).getDenominador() + "");
		simboloOperacion.setText(((String) (ejercicio.get("signo"))));
//Si quereis hacer test aqui los resultados en interfaz
//		numeradorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getNumerador() + "");
//		denominadorResultado.setText(((Fraccion) (ejercicio.get("resultado"))).getDenominador() + "");

		setTitle(((String) (ejercicio.get("tipo"))));
		fracccionResultado = (Fraccion) ejercicio.get("resultado");
		mostrarElementos();
		vistaResultado = false;
	}
}
