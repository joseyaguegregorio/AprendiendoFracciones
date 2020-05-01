package principal;



public class Fraccion {
	
	private int numerador;
	private int denominador;
	

	public Fraccion(int numerador, int denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	public Fraccion() {
			super();
		}

	
	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}


	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(numerador).append(" / ").append(denominador);
		return sb.toString();
	}
	
	//Suma de Fracciones
	
	public static Fraccion sumar(Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion();
		aux.numerador = a.numerador * b.denominador + a.denominador * b.numerador;
		aux.denominador = a.denominador * b.denominador;
		
		return CalculosMatematicos.simplificar(aux);

	}
	
	//Resta de Fracciones
	
	public static Fraccion restar(Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion();
		aux.numerador = a.numerador * b.denominador - a.denominador * b.numerador;
		aux.denominador = a.denominador * b.denominador;
	
		return CalculosMatematicos.simplificar(aux);
		
	}
	
	//Multiplicacion de Fracciones
	
	public static Fraccion multiplicacion(Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion ();
		aux.numerador = a.numerador * b.numerador;
		aux.denominador = a.denominador * b.denominador;
		
		return CalculosMatematicos.simplificar(aux);
	}
	
	//División de Fracciones
	
	public static Fraccion division(Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion();
		aux.numerador = a.numerador * b.denominador;
		aux.denominador = a.denominador * b.numerador;
		
		return CalculosMatematicos.simplificar(aux);
		
	} 

}




























