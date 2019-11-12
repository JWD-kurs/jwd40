package jwd.wafepa.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
public class ApiActivityController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Activity>> getActivities(){
		
		return new ResponseEntity<>(activityService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<Activity> getActivity(@PathVariable Long id) {
		Activity activity = activityService.findOne(id);
		
		if(activity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(activity, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Activity> delete(@PathVariable Long id){
		Activity deleted = activityService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Activity> add(
			@RequestBody Activity toAdd){
		
		Activity persisted = activityService.save(toAdd);
		
		return new ResponseEntity<>(
				persisted, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Activity> edit(
			@PathVariable Long id,
			@RequestBody Activity edited){
		
		if(id != edited.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Activity persisted = activityService.save(edited);
		
		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}

	@PostConstruct
	public void init() {
		activityService.save(new Activity("Swimming"));
		activityService.save(new Activity("Running"));
	}
}
