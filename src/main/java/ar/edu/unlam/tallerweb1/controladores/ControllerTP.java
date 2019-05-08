package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerTP {

	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	
	@RequestMapping(path = "/enviar-cadena", method = RequestMethod.POST)
	public ModelAndView procesarCadena(@RequestParam String cadena, @RequestParam String nombreOperacion) {
		ModelMap modelo = new ModelMap();
		
		if(cadena == null || "".equals(cadena)) {
			modelo.addAttribute("error", "No se introdujo ningún valor");
			return new ModelAndView("error", modelo);
		}
		
		String cadenaResultado = "";
		Integer cantidadCaracteres = 0;
		
		switch(nombreOperacion) {
		case "mayus":
			cadenaResultado = cadena.toUpperCase();
			break;
			
		case "minus":
			cadenaResultado = cadena.toLowerCase();
			break;
			
		case "invert":
			StringBuilder bld = new StringBuilder();
			for(int i = cadena.length() - 1; i >= 0; i--)
	        {
				bld.append(cadena.charAt(i));
	        }
			cadenaResultado = bld.toString();
			break;
			
		case "cant":
			cantidadCaracteres = cadena.length();
			break;
			
		default:
			//Error
			break;
		}
		
		if(!("".equals(cadenaResultado))) {
			modelo.addAttribute("cadenaResultado", cadenaResultado);
		} else if(cantidadCaracteres != 0) {
			modelo.addAttribute("cantidadCaracteres", cantidadCaracteres);
		} else {
			modelo.addAttribute("error", "Se ha producido un error");
			return new ModelAndView("error", modelo);
		}
		
		
		return new ModelAndView("cadena-resultado", modelo);
	}
	
}
