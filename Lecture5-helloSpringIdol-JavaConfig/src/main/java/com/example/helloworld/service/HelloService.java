package com.example.helloworld.service;

import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springidol.Instrument;
import com.example.springidol.Performer;

@Service
public class HelloService {	
	@Autowired		// 모든 Performer 타입 bean들을 주입(ID를 key로 사용)
	private Map<String, Performer> performers; 
	
	public String getGreeting() {			
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <= 10) {
			return "Good morning, ";
		} else if (hour >= 12 && hour <= 15) {
			return "Did you have lunch? ";
		} else if (hour >= 18 && hour <= 24) {
			return "Good evening, ";
		}
		return "Hello, ";
	}
	
	public String makePerformance(String id, int num) {
		Performer performer = performers.get(id);
		
		if (performer != null) {
			StringBuffer result = new StringBuffer();
			for (int i = 0; i < num; i++) {
				result.append(performer.perform());
				result.append("<br/>");
			}
			return result.toString();
		}
		return null;
	}
}
