package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {
	
	List<String> personas = new LinkedList();

	@RequestMapping(value="/lista-personas", method= RequestMethod.GET)
	public ModelAndView listaDePersonas(@RequestParam String nombre, @RequestParam String apellido){
		ModelMap modelo = new ModelMap();

		personas.add(apellido);
		
		modelo.put("personas", personas);
		
		return new ModelAndView("lista-personas", modelo);
	}
	
	@RequestMapping(value="/lista-personas/{nombre}/{apellido}", method = RequestMethod.GET)
	public ModelAndView listaDePersonasPath(@PathVariable String nombre, @PathVariable String apellido){
		ModelMap modelo = new ModelMap();

		personas.add(apellido);
		
		modelo.put("personas", personas);
		
		return new ModelAndView("lista-personas", modelo);
	}
}
