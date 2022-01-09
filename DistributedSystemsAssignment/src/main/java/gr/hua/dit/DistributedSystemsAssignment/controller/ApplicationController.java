package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@GetMapping("/applications")
	public List<Application> getAllApplications() {
		return applicationService.getApplications();
	}
	
	@GetMapping("/applications/{id}")
	public Application getApplication(@PathVariable int id) {
		return applicationService.getApplication(id);
	}
	
	@PostMapping("/applications")
	public void newApplication(@RequestBody Application newApplication) {
		applicationService.saveApplication(newApplication);
	}
	
	@PutMapping("/applications/{id}")
	public void replaceApplication(@RequestBody Application newApplication,@PathVariable int id) {
		applicationService.updateApplication(newApplication,id);
	}
	
	@DeleteMapping("/applications/{id}")
	public ResponseEntity<Object> deleteApplication(@PathVariable int id) {
		applicationService.deleteApplication(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
