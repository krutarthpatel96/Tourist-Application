package dal.cloud.tourism.Analytics.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dal.cloud.tourism.Analytics.repository.JourneyAnalyticsRepository;

@RestController
@RequestMapping("journeyStats")
public class JourneyAnalyticsController {

	@Autowired
	JourneyAnalyticsRepository journeyAnalyticsRepository;

	@RequestMapping("/crowdForAllJourneys")
	public List<Map<String,String>> getCrowdStatsForAllJourneys() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<Object[]> lst = new ArrayList<Object[]>();
		Map<String,String> map;
		
		lst = journeyAnalyticsRepository.getCrowdStatsForAllJourneys();
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("date",val);
				break;
				
				case 1: map.put("busCapacity",val);
				break;
				
				case 2: map.put("freeSeats",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/crowdByJourneyId")
	public List<Map<String,String>> getCrowdStatsByJourneyId(@RequestParam("journeyId") int journeyId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object[]> lst = new ArrayList<Object[]>();
		lst = journeyAnalyticsRepository.getJourneyCrowdStatsbyJourneyId(journeyId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("date",val);
				break;
				
				case 1: map.put("busCapacity",val);
				break;
				
				case 2: map.put("freeSeats",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/crowdByDate")
	public List<Map<String,String>> getCrowdStatsByDate(@RequestParam("date") String date) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object[]> lst = new ArrayList<Object[]>();
		lst = journeyAnalyticsRepository.getJourneyCrowdStatsbyDate(date);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("date",val);
				break;
				
				case 1: map.put("busCapacity",val);
				break;
				
				case 2: map.put("freeSeats",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
}
