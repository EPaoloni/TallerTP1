package ar.edu.unlam.tallerweb1.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTP;

@Controller
public class ControllerTP {
	
	@Autowired
	private ServicioTP servicioTP;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	/**
	 * Metodo del TP con path variable
	 * 
	 * @param nombreOperacion
	 * @param cadena
	 * @return
	 */
	@RequestMapping(path="/enviar-cadena/{nombreOperacion}/{cadena}", method = RequestMethod.GET)
	public ModelAndView procesarCadenaPathVariable(@PathVariable String nombreOperacion, @PathVariable String cadena) {
		ModelMap modelo = new ModelMap();
		
		String errorLiteral = "error";
		String resultadoLiteral = "resultado";

		Map<String, Object> mapResultado = servicioTP.operacionCadena(cadena, nombreOperacion);
		
		if(mapResultado.containsKey(resultadoLiteral)) {
			modelo.addAttribute(resultadoLiteral, mapResultado.get(resultadoLiteral));
		} else if(mapResultado.containsKey(errorLiteral)) {
			modelo.addAttribute(errorLiteral, mapResultado.get(errorLiteral));
			return new ModelAndView(errorLiteral, modelo);
		}
		
		return new ModelAndView("cadena-resultado", modelo);
	}
	
	
	/**
	 * Metodo para el form en home
	 * 
	 * @param cadena
	 * @param nombreOperacion
	 * @return
	 */
	@RequestMapping(path = "/enviar-cadena", method = RequestMethod.POST)
	public ModelAndView procesarCadena(@RequestParam String cadena, @RequestParam String nombreOperacion) {
		ModelMap modelo = new ModelMap();
		
		String errorLiteral = "error";
		String resultadoLiteral = "resultado";
		
		if(cadena == null || "".equals(cadena)) {
			modelo.addAttribute(errorLiteral, "No se introdujo ningún valor");
			return new ModelAndView(errorLiteral, modelo);
		}

		Map<String, Object> mapResultado = servicioTP.operacionCadena(cadena, nombreOperacion);
		
		if(mapResultado.containsKey(resultadoLiteral)) {
			modelo.addAttribute(resultadoLiteral, mapResultado.get(resultadoLiteral));
		} else if(mapResultado.containsKey(errorLiteral)) {
			modelo.addAttribute(errorLiteral, mapResultado.get(errorLiteral));
			return new ModelAndView(errorLiteral, modelo);
		}
		
		return new ModelAndView("cadena-resultado", modelo);
	}
	
}
