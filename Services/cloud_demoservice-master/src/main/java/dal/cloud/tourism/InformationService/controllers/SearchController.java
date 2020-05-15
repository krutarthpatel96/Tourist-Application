package dal.cloud.tourism.InformationService.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dal.cloud.tourism.InformationService.repository.SearchRepository;

@RestController
@RequestMapping("search")
class SearchContoller{

	@Autowired
	SearchRepository searchRepository;
	
	@RequestMapping("/getPlaces")
	public Map<String,List<Map<String,String>>> getPlaces(@RequestParam("keyword") String keyword) {
		Map<String,List<Map<String,String>>> list = new HashMap<String,List<Map<String,String>>>();
		
		List<Map<String,String>> touristLocations = new ArrayList<Map<String,String>>();
		List<Map<String,String>> cities = new ArrayList<Map<String,String>>();
		
		List<Object []> temp = new ArrayList<Object[]>();
		Map<String,String> map = new HashMap<String,String>();
		
		temp = searchRepository.getTouristLocations(keyword);
		
		for(int i=0;i<temp.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = temp.get(i);
			
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";
				switch(j){
				
				case 0: map.put("location_Id",val);
				break;
				
				case 1: map.put("city_Id",val);
				break;
				
				case 2: map.put("name",val);
				break;
				
				case 3: map.put("type",val);
				break;
				
				case 4: map.put("url",val);
				break;
				
				case 5: map.put("features",val);
				break;
				}
			}
			
			touristLocations.add(map);
		}
		
		temp = new ArrayList<Object[]>();
		map = new HashMap<String,String>();
		
		temp = searchRepository.getCities(keyword);
		
		for(int i=0;i<temp.size();i++) {
			map = new HashMap<String,String>();
			Object[] ob = temp.get(i);
			for(int j = 0;j<ob.length;j++){
				
				String val = ob[j]+"";

				switch(j){
				
				case 0: map.put("city_Id",val);
				break;
				
				case 1: map.put("name",val);
				break;
				
				case 2: map.put("province",val);
				break;
				
				case 3: map.put("url",val);
				break;
				
				}
			
			}
			cities.add(map);
		}
				
		list.put("touristLocation", touristLocations);
		list.put("cities", cities);
	
		return list;
	}
}
