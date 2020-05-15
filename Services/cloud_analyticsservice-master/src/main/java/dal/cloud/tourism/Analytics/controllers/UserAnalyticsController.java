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
import dal.cloud.tourism.Analytics.repository.UserAnalyticsRepository;

@RestController
@RequestMapping("userStats")
public class UserAnalyticsController {

	@Autowired
	UserAnalyticsRepository userAnalyticsRepository;

	@RequestMapping("/bookingCount")
	public List<Map<String,String>> getBookingCount(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object[]> lst = new ArrayList<Object[]>();
		lst = userAnalyticsRepository.getBookingCount(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("totalBookings",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/bookingByMonth")
	public List<Map<String,String>> getBookingsCountByMonth(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getBookingCountByMonth(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("month",val);
				break;
				
				case 1: map.put("bookingsMade",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/bookingByYear")
	public List<Map<String,String>> getBookingsCountByYear(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getBookingCountByYear(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("year",val);
				break;
				
				case 1: map.put("bookingsMade",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/destinationsCount")
	public List<Map<String,String>> getDestinationsCount(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getDestinationsCount(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("destinationsVisited",val);
				break;

				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/destinationsByMonth")
	public List<Map<String,String>> getDestinationsCountByMonth(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getDestinationsCountByMonth(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("month",val);
				break;
				
				case 1: map.put("destinationVisits",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/destinationsByYear")
	public List<Map<String,String>> getDestinationsCountByYear(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getDestinationsCountByYear(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("year",val);
				break;
				
				case 1: map.put("destinationVisits",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/moneySpent")
	public List<Map<String,String>> getMoneySpent(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getMoneySpent(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("totalMoneySpent",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/moneySpentByMonth")
	public List<Map<String,String>> getMoneySpentByMonth(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getMoneySpentByMonth(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("month",val);
				break;
				
				case 1: map.put("totalMoneySpent",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/moneySpentByYear")
	public List<Map<String,String>> getMoneySpentByYear(@RequestParam("userId") String userId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		
		List<Object []> lst = new ArrayList<Object []>();
		lst = userAnalyticsRepository.getMoneySpentByYear(userId);
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		
		for(int i=0;i<lst.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = lst.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				
				switch(j){
				
				case 0: map.put("year",val);
				break;
				
				case 1: map.put("totalMoneySpent",val);
				break;
				
				}
			}
			
			list.add(map);
		}
		
		return list;
	}
}
