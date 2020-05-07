package principal;

import java.util.HashMap;

import com.sun.tools.sjavac.server.SysInfo;

public class maintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap <String, Object> ejercicio = CalculosMatematicos.crearEjercicio ("suma", "fácil");
		
		System.out.println(ejercicio.keySet());
		System.out.println(ejercicio.values());

		
		;
		
	}

}
