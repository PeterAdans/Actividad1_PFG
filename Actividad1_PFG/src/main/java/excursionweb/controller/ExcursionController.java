package excursionweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import excursionweb.modelo.dao.ExcursionDao;
import excursionweb.modelo.javabean.Excursion;




@Controller
public class ExcursionController {
	
	@Autowired
	private ExcursionDao pdao;
	
	
	@GetMapping("/excursiones/creados")
	public String creados(Model model) {
		model.addAttribute("creados", pdao.findByCreados());
		
		return "creados";
	}
	
	@GetMapping("/excursiones/terminados")
	public String terminados(Model model) {
		model.addAttribute("terminados", pdao.findByTerminados());
		
		return "terminados";
	}
	
	
	@GetMapping("/excursiones/destacados")
	public String destacados(Model model) {
		model.addAttribute("destacados", pdao.findByDestacados());
		
		return "destacados";
	}
	
	@PostMapping("/excursiones/modificar/{idExcursion}")
	public String proFormPost(@PathVariable int idExcursion, Excursion excursion, 
			RedirectAttributes ratt) {
		excursion.setIdExcursion(idExcursion);
		if (pdao.updateOne(excursion) == 1)
			ratt.addFlashAttribute("mensaje", "Excursión modificada correctamente");
		else
			ratt.addFlashAttribute("mensaje", "La excursión no se ha podido modificadar");
			
		return "redirect:/"; //para la tarea, quema los datos y solo sobrevive el ratt
	}
	
	@GetMapping("/excursiones/modificar/{idExcursion}")
	public String procModificar(Model model, @PathVariable int idExcursion) {
		
		Excursion excursion = pdao.findById(idExcursion);
		if (excursion == null) {
			model.addAttribute("mensaje", "La excursión no existe");
			return "forward:/";	
		}
		
		    model.addAttribute("excursion", excursion);
		
		return "FormEdicionExcursion";
	}
	
	@PostMapping("/excursiones/alta")
	public String procFormAlta(Excursion excursion, RedirectAttributes ratt) {
	
		if (pdao.insertOne(excursion) == 1)
			ratt.addFlashAttribute("mensaje", "Nueva excursión registrada");
		else
			ratt.addFlashAttribute("mensaje", "Excursión no registrada");
			         
			
		
		
		return "redirect:/";
	}
	
	@GetMapping("/excursiones/alta")
	public String procAlta() {
		return "FormNuevaExcursion";
	}
	
	@GetMapping("/excursiones/cancelar/{idExcursion}")
	public String procCancelar(Model model, @PathVariable int idExcursion) {
		
		Excursion excursion = pdao.findById(idExcursion);
		if (! excursion.getEstado().equals("CANCELADO")) {
			excursion.setEstado("CANCELADO");
			model.addAttribute("mensaje", "La excursión ha sido cancelada ");
			
			return "forward:/";	
		}
		
		    model.addAttribute("mensaje", "La excursión no ha sido cancelada ");
		    return "forward:/";
		}

	
	
	
	
	
	
	@GetMapping("excursiones/detalle/{idExcursion}")
	public String verDetalle(Model model, @PathVariable int idExcursion) {
		
		Excursion excursion = pdao.findById(idExcursion);
		
		model.addAttribute("excursion", excursion);

	
	return"verDetalle";
	
	}
	
	
	
	
	
}
