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

import dal.cloud.tourism.Analytics.repository.DestinationAnalyticsRepository;
import dal.cloud.tourism.Analytics.repository.JourneyAnalyticsRepository;

@RestController
@RequestMapping("destinationStats")
public class DestinationAnalyticsController {

	@Autowired
	DestinationAnalyticsRepository destinationAnalyticsRepository;

	@RequestMapping("/journeysForAllDestinations")
	public List<Map<String,String>> getJourneysForAllDestinations() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object[]> lst = new ArrayList<Object[]>();
		lst = destinationAnalyticsRepository.getJourneyStatsForAllDestinations();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("totalJourneys",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/journeysForAllDestinationsByMonth")
	public List<Map<String,String>> getJourneysForAllDestinationsByMonth() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = destinationAnalyticsRepository.getJourneyStatsForAllDestinationsByMonth();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("month",val);
				break;
				
				case 3: map.put("totalJourneys",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/journeysForAllDestinationsByYear")
	public List<Map<String,String>> getJourneysForAllDestinationsByYear() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = destinationAnalyticsRepository.getJourneyStatsForAllDestinationsByYear();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("year",val);
				break;
				
				case 3: map.put("totalJourneys",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/crowdForAllDestinations")
	public List<Map<String,String>> getCrowdStatsForAllDestinations() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = destinationAnalyticsRepository.getCrowdStatsForAllDestinations();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("visits",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/crowdForAllDestinationsByMonth")
	public List<Map<String,String>> getCrowdStatsForAllDestinationsByMonth() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = destinationAnalyticsRepository.getCrowdStatsForAllDestinationsByMonth();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("month",val);
				break;
				
				case 3: map.put("totalJourneys",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/crowdForAllDestinationsByYear")
	public List<Map<String,String>> getCrowdStatsForAllDestinationsByYear() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = destinationAnalyticsRepository.getCrowdStatsForAllDestinationsByYear();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("year",val);
				break;
				
				case 3: map.put("totalJourneys",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/journeysByDestinationId")
	public List<Map<String,String>> getJourneysByDestinationId(@RequestParam("destinationId") int destinationId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = destinationAnalyticsRepository.getJourneysbyDestinationId(destinationId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("totalJourneys",val);
				break;

				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/crowdByDestinationId")
	public List<Map<String,String>> getCrowdStatsByDestinationId(@RequestParam("destinationId") int destinationId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = destinationAnalyticsRepository.getCrowdStatsbyDestinationId(destinationId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("cityName",val);
				break;
				
				case 1: map.put("provinceName",val);
				break;
				
				case 2: map.put("totalJourneys",val);
				break;

				}
			}
			
			list.add(map);
		}
		
		return list;
	}
}
