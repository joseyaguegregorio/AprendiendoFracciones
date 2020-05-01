package principal;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class CalculosMatematicos {
	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}

	/*
	 * 
	 * Este m√©todo se usa para descomponer un n√∫mero en sus factores primos Genera
	 * un mapa ordenado donde cada clave es un divisor primo del n√∫mero y cuyo valor
	 * es el n√∫mero de veces que incluye ese divisor primo.
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

	// m·ximo com˙n divisor
	
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
	
	
	//mÌnimo com˙n m˙ltiplo
	
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
	
	// fracciÛn mayor, si a>=b devuelve true, si b>a devuelve false.
	
	public boolean esMayorIgual (Fraccion a, Fraccion b) {
		boolean esMayorIgual = false;
		double numeradorA = a.getNumerador();
		double denominadorA = a.getDenominador();
		double numeradorB = b.getNumerador();
		double denominadorB = b.getDenominador();
		
		if((numeradorA/denominadorA)>=(numeradorB/denominadorB))
			esMayorIgual=true;
		
		return esMayorIgual;			
		
	}
	
	
}