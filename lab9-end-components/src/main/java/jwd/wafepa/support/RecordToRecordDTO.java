package jwd.wafepa.support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Record;
import jwd.wafepa.web.dto.RecordDTO;

@Component
public class RecordToRecordDTO implements Converter<Record, RecordDTO>{

	@Override
	public RecordDTO convert(Record record) {
		
		RecordDTO retValue = new RecordDTO();
		retValue.setId(record.getId());
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		String datetime = formatter.format(record.getTime());
		retValue.setTime(datetime);
		
		
		retValue.setDuration(record.getDuration());
		retValue.setIntensity(record.getIntensity());
		
		retValue.setUserId(record.getUser().getId());
		retValue.setActivityId(record.getActivity().getId());
		
		retValue.setUserName(record.getUser().getFirstName() + ", " + record.getUser().getLastName());
		retValue.setActivityName(record.getActivity().getName());
		
		return retValue;
	}

	public List<RecordDTO> convert(List<Record> records){
		List<RecordDTO> ret = new ArrayList<>();
		
		for(Record record : records){
			ret.add(convert(record));
		}
		
		return ret;
	}

}
