package dal.cloud.tourism.InformationService.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dal.cloud.tourism.InformationService.model.TouristLocation;
import dal.cloud.tourism.InformationService.repository.TouristLocationRepository;

@RestController
@RequestMapping("touristLocations")
public class LocationController {

	@Autowired
	TouristLocationRepository touristLocationRepository;
	
	@RequestMapping("/all")
	public List<TouristLocation> getLocations(){
		List<TouristLocation> list = new ArrayList<TouristLocation>();
		list = touristLocationRepository.findAll();
		return list;
	}
	
	@RequestMapping("/locationsByProvince")
	public List<TouristLocation> getLocationsByProvinceId(@RequestParam("province") String province){
		List<TouristLocation> list = new ArrayList<TouristLocation>();
		list = touristLocationRepository.getLocationsByProvince(province);
		return list;
	}
	
	@RequestMapping("/locationsByCityId")
	public List<TouristLocation> getLocationsByCityId(@RequestParam("cityId") int cityId){
		List<TouristLocation> list = new ArrayList<TouristLocation>();
		list = touristLocationRepository.getLocationsByCityId(cityId);
		return list;
	}
	
	@RequestMapping("/locationById")
	public List<TouristLocation> getLocationByLocationId(@RequestParam("locationId") int locationId){
		Optional<TouristLocation> list;
		list = touristLocationRepository.findById(locationId);
		return list.stream().collect(Collectors.toList());
	}
	
}
