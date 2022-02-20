package gr.hua.dit.DistributedSystemsAssignment.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;


@Controller
@RequestMapping("/OASAPage")
public class OASAController {
	
	@Autowired
	private ApplicationService applicationService;

	@ModelAttribute("application")
	public Application registrationApp() {
		return new Application();
	}
	
	@GetMapping
	public String showApplications(Model model) {
		
		List<Application>applications=applicationService.getNotAuthorizedApplications();
		model.addAttribute("applications", applications);
		
		return "OASAPage";
	}
	
	@GetMapping("/validationForm/{id}")
	public ModelAndView validationForm(@PathVariable (name="id") Integer id) {
		ModelAndView validation=new ModelAndView("validationForm");
		Application application = applicationService.getApplication(id);
		validation.addObject("application",application);
		return validation;
	}
	
	@PostMapping("/saveValidation")
	public String saveValidation(@ModelAttribute("application") Application application) {
		applicationService.saveApplication(application);
		return "redirect:/";
	}
	

}
