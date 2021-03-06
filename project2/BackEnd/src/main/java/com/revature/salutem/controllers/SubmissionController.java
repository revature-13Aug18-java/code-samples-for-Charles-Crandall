package com.revature.salutem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.SubmissionIdNotFoundException;
import com.revature.salutem.models.Account;
import com.revature.salutem.models.Submission;
import com.revature.salutem.services.SubmissionDaoImpl;

@RestController
@RequestMapping("/submissions")
@CrossOrigin
public class SubmissionController {

	@Autowired
	SubmissionDaoImpl subServ;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Submission> getAllSubmissions(){
		return subServ.allSubmissions();
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Submission getSubmissionById(@PathVariable("id") int id)  {
		Submission a = subServ.getSubmission(id);
		if(a == null) {
			throw new SubmissionIdNotFoundException();
		}
		return a;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Submission createSubmission(@RequestBody Submission acc) {
		return subServ.createSubmission(acc);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Submission updateSubmission(@RequestBody Submission acc) {
		return subServ.updateSubmission(acc);
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteSubmission(@RequestBody Submission acc) {
		subServ.deleteSubmission(acc);
	}
	
	@DeleteMapping(value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteSubmission(@PathVariable("id") int id) {
		subServ.deleteSubmissionById(id);
	}	
	
	@RequestMapping(method= {RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.TRACE, RequestMethod.PATCH})
	public Account metadataCar() {
		return null;
	}
	
//	@DeleteMapping(value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public void deleteSubmissionByIdAndDate(@RequestBody Account acc, @PathVariable("id") int id) {
//		subServ.deleteSubmissionsByAccountIdAndSubmissionDate(acc, SPECIFICDAY);
//	}	
}
