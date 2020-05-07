package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class CalculosMatematicos {
	
	
	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}

	/*
	 * 
	 * Este método se usa para descomponer un número en sus factores primos Genera
	 * un mapa ordenado donde cada clave es un divisor primo del número y cuyo valor
	 * es el número de veces que incluye ese divisor primo.
	 * 
	 */
	public static SortedMap<Integer, Integer> divisores(int numero) {
		SortedMap<Integer, Integer> divisores = new TreeMap<Integer, Integer>();
		int numeroIntermedio = numero;
		Integer divisor = 2;
		while (numeroIntermedio >= divisor) {
			while (numeroIntermedio % divisor == 0) {
				Integer clave = divisor;
				divisores.putIfAbsent(divisor, 0);
				divisores.computeIfPresent(clave, (key, val) -> (val + 1));
				numeroIntermedio = numeroIntermedio / divisor;
			}

			divisor++;
		}
		return divisores;
	}

	public static ArrayList<Integer> listaDePrimosHasta(int numero) {
		ArrayList<Integer> listaDePrimos = new ArrayList<Integer>();
		listaDePrimos.add(1);
		listaDePrimos.add(2);
		listaDePrimos.add(3);
		for (int i = 5; i <= numero; i += 2) {
			if (esPrimo(i))
				listaDePrimos.add(i);
		}
		return listaDePrimos;
	}

	public static int potencia(int base, int exponente) {

		int resul = 1;
		if (exponente > 0)
			resul = base * potencia(base, exponente - 1);
		return resul;
	}

	public static boolean esPrimo(int numero) {

		boolean primo = true;
		int divisor = 3;
		if (numero != 2 && numero % 2 == 0)
			primo = false;
		while (primo && divisor <= Math.sqrt(numero)) {
			if (numero % divisor == 0)
				primo = false;
			divisor += 2;
		}
		return primo;
	}

	// maximo comun divisor
	
	public static int mcd(int a, int b) {
		int mcd = 1;
		if(a<b) {
			int aux = a;
			a = b;
			b = aux;		
		}
		for(int i=1; i<=b; i++) {
			if(a%i==0 && b%i==0){
				mcd = i;
			}	
		}
		return mcd;
	}
	
	
	// simplificar fracciones
	
	public static Fraccion simplificar(Fraccion a) {
		int numerador = a.getNumerador();
		int denominador = a.getDenominador();
		Fraccion simplificada;
		boolean esNegativo = false;
		
		if (numerador<0) {
			esNegativo = true;
			numerador = Math.abs(numerador);	
		} else if (denominador<0){
			esNegativo = true;
			denominador = Math.abs(denominador);
		}	
		int mcd = mcd(numerador, denominador);
		
		if(esNegativo) {
			simplificada = new Fraccion (numerador/mcd*-1,denominador/mcd);
		}
		else {
			simplificada = new Fraccion (numerador/mcd,denominador/mcd);
		}
		return simplificada;
	}
	
	
	//minimo comun multiplo
	
	public static int mcm(int a, int b) {
		int mcm = 1;
		int multiplicacion = a*b;
		if(a<b) {
			int aux = a;
			a = b;
			b = aux;		
		}
		for (int i = multiplicacion; i>=a; i--) {
			if(i%a==0 && i%b==0) {
				mcm = i;
			}
		}
		return mcm;	
	}
	
	// fraccion mayor, si a>=b devuelve true, si b>a devuelve false.
	
	public static boolean esMayorIgual (Fraccion a, Fraccion b) {
		boolean esMayorIgual = false;
		double numeradorA = a.getNumerador();
		double denominadorA = a.getDenominador();
		double numeradorB = b.getNumerador();
		double denominadorB = b.getDenominador();
		
		if((numeradorA/denominadorA)>=(numeradorB/denominadorB))
			esMayorIgual=true;
		
		return esMayorIgual;			
		
	}
	
	//crear fraccion random
	
	public static Fraccion crearFraccion (String dificultad) {
		Fraccion fraccion = new Fraccion();
		
		switch(dificultad) {
		//ojo con las tildes!!!!
		case "facil":
			//Fracciones con denominador y numerador de 1 a 10.
			fraccion.setNumerador((int) (Math.random()*10)+1);
			fraccion.setDenominador((int) (Math.random()*10)+1);
			break;
		case "medio":
			//Fracciones de 11 a 20.
			fraccion.setNumerador((int) (Math.random()*10+10));
			fraccion.setDenominador((int) (Math.random()*10+10));
			break;
		case "dificil":
			//Fracciones de 20 a 50.
			fraccion.setNumerador((int) (Math.random()*30+20));
			fraccion.setDenominador((int) (Math.random()*30+20));
			break;
		}
		return fraccion;
	}
	
	public static HashMap<String, Object> crearEjercicio (String tipo, String dificultad) {
		HashMap<String, Object> ejercicio = new HashMap<String, Object>();
		Fraccion a, b, resultado = null;
		String signo ="";
		//generar las fracciones a y b
		a = CalculosMatematicos.crearFraccion(dificultad);
		b = CalculosMatematicos.crearFraccion(dificultad);
		
		//Se calcula el resultado en funci�n del tipo de operaci�n.
		switch(tipo) {
		case "suma":
			signo = "+";
			resultado = Fraccion.sumar(a, b);
			resultado = CalculosMatematicos.simplificar(resultado);		
			tipo = "Suma";
		break;		
		case "resta":
			signo = "-";
			if (CalculosMatematicos.esMayorIgual(b, a)) {
				Fraccion aux = b;
				a = b;
				b = aux;
			} 
			resultado = Fraccion.restar(a, b);
			resultado = CalculosMatematicos.simplificar(resultado);	
			tipo = "Resta";
		break;	
		case "multiplicacion"://ojo con las t�ldes!!!!
			signo = "x";
			resultado = Fraccion.multiplicacion(a, b);
			resultado = CalculosMatematicos.simplificar(resultado);	
			tipo = "Multiplicacion";
		break;	
		case "division"://ojo con las t�ldes!!!!
			signo = ":";
			resultado = Fraccion.division(a, b);
			resultado = CalculosMatematicos.simplificar(resultado);	
			tipo = "Division";
		break;
		}	
		//Se anaden los datos al HashMap.
		ejercicio.put("signo", signo); //String
		ejercicio.put("fraccionA", a); //Fraccion
		ejercicio.put("fraccionB", b); //Fraccion
		ejercicio.put("resultado", resultado); //Fraccion
		ejercicio.put("tipo", tipo); //String
		ejercicio.put("dificultad", dificultad); //String
				
		return ejercicio;
	}
	
}