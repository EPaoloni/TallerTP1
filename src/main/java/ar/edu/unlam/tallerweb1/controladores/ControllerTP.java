package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerTP {

	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(path = "/enviar-cadena", method = RequestMethod.POST)
	public ModelAndView procesarCadena() {
		ModelMap modelo = new ModelMap();
		
		
		
		
		return new ModelAndView("cadena-resultado", modelo);
	}
	
}
