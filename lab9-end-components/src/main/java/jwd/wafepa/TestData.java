package jwd.wafepa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Intensity;
import jwd.wafepa.model.Record;
import jwd.wafepa.model.User;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.RecordService;
import jwd.wafepa.service.UserService;

@Component
public class TestData {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecordService recordService;
	
	@PostConstruct
	public void init() throws ParseException {
		Activity activity1 = activityService.save(new Activity("Swimming"));
		Activity activity2 = activityService.save(new Activity("Running"));
		
		User user1 = new User();
		user1.setFirstName("First name " + 1);
		user1.setLastName("Last name " + 1);
		user1.setEmail("email" + 1 + "@example.com");
		user1.setPassword("123");
		user1 = userService.save(user1);

		User user2 = new User();
		user2.setFirstName("First name " + 2);
		user2.setLastName("Last name " + 2);
		user2.setEmail("email" + 2 + "@example.com");
		user2.setPassword("123");
		user2 = userService.save(user2);
		
		
		Record record1 = new Record();
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		Date datetime = formatter.parse("20/11/2018, 08:00");
		record1.setTime(datetime);
		record1.setDuration(60);
		record1.setIntensity(Intensity.LOW);
		record1.setUser(user1);
		record1.setActivity(activity1);
		recordService.save(record1);
		
		Record record2 = new Record();
		Date datetime2 = formatter.parse("21/11/2018, 08:00");
		record2.setTime(datetime2);
		record2.setDuration(60);
		record2.setIntensity(Intensity.MEDIUM);
		record2.setUser(user2);
		record2.setActivity(activity2);
		recordService.save(record2);
	}
}
