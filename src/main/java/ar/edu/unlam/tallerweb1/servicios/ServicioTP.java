package ar.edu.unlam.tallerweb1.servicios;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ServicioTP {
	
	public Map<String, Object> operacionCadena(String cadena, String operacion) {

		
		String cadenaResultado = "";
		Integer cantidadCaracteres = 0;
		String resultado = "resultado";
		Map<String, Object> mapResultado = new HashMap<>();
		
		switch(operacion) {
		case "mayus":
			cadenaResultado = cadena.toUpperCase();
			mapResultado.put(resultado, cadenaResultado);
			break;
			
		case "minus":
			cadenaResultado = cadena.toLowerCase();
			mapResultado.put(resultado, cadenaResultado);
			break;
			
		case "invert":
			StringBuilder bld = new StringBuilder();
			for(int i = cadena.length() - 1; i >= 0; i--)
	        {
				bld.append(cadena.charAt(i));
	        }
			cadenaResultado = bld.toString();
			mapResultado.put(resultado, cadenaResultado);
			break;
			
		case "cant":
			cantidadCaracteres = cadena.length();
			mapResultado.put(resultado, cantidadCaracteres);
			break;
			
		default:
			mapResultado.put("error", "Ha ocurrido un error con la clave de operacion");
			break;
		}
		
		return mapResultado;
	}
}
