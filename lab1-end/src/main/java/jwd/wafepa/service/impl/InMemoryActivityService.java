package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

public class InMemoryActivityService 
	implements ActivityService{
	
	private Map<Long, Activity> activities
		= new HashMap<>();
	private long nextId = 1l;

	@Override
	public List<Activity> findAll() {
		return new ArrayList<>( activities.values());
	}

	@Override
	public Activity findOne(Long id) {
		return activities.get(id);
	}

	@Override
	public Activity save(Activity activity) {
		if(activity.getId() == null) {
			activity.setId(nextId);
			nextId += 1l;
		}
		activities.put(activity.getId(), activity);
		
		return activity;
	}

	@Override
	public Activity delete(Long id) {
		if(!activities.containsKey(id)) {
			throw new IllegalArgumentException(
					"Tried to remove non-existing activity!");
		}
		
		return activities.remove(id);
	}

}
