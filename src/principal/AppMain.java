package principal;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class AppMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Ejemplo de uso del método CalculosMatematicos.divisores
		 * Este método descompone un número en factores primos
		 * Retornando un mapa con los factores primos
		 */
		int num = 180;
		SortedMap<Integer,Integer> divisores = new TreeMap<>();
		divisores=CalculosMatematicos.divisores(num);
		for(Map.Entry<Integer, Integer> entrada: divisores.entrySet()) {
			int divisor=entrada.getKey();
			int numeroVeces=entrada.getValue();
			for(int i=1;i<=numeroVeces;i++) {
			System.out.println(num+"\t|\t"+divisor);
			num=num/divisor;
			}
		}
				
		Fraccion ejempoFraccion = new Fraccion(3, 100);		
		System.out.println("\n\nPara ver como funciona toString en Fraccion:\t"+ejempoFraccion);
	

	//tests de pedro
	
		//test mcd
		System.out.println("mcd test1: "+CalculosMatematicos.mcd(100, 100));
		System.out.println("mcd test2: "+CalculosMatematicos.mcd(400, 1000));
		System.out.println("mcd test3: "+CalculosMatematicos.mcd(13, 7));
		System.out.println("");
	
		
	//test mcd
	Fraccion a = new Fraccion (54,14);
	System.out.println("simplificar test1: "+CalculosMatematicos.simplificar(a).toString());;
	
	Fraccion b = new Fraccion (14,54);
	System.out.println("simplificar test2: "+CalculosMatematicos.simplificar(b).toString());;
	System.out.println("");
	
	//test mcm
	
	System.out.println("mcm test1: "+CalculosMatematicos.mcm(100, 100));
	System.out.println("mcm test2: "+CalculosMatematicos.mcm(400, 1000));
	System.out.println("mcm test3: "+CalculosMatematicos.mcm(13, 7));
	System.out.println("");
	
	
	
	}
	
	//fin tests pedro

}