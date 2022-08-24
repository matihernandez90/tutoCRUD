package templates;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		String nombre="Paco";
		model.addAttribute("nombre", nombre);
		return "home";
	}
}
