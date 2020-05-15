package dal.cloud.tourism.InformationService.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dal.cloud.tourism.InformationService.model.City;
import dal.cloud.tourism.InformationService.repository.CityRepository;
import dal.cloud.tourism.InformationService.repository.TouristLocationRepository;

@RestController
@RequestMapping("cities")
public class CityController {

	@Autowired
	CityRepository cityRepository;
	
	@RequestMapping("/all")
	public List<City> getCities(){
		List<City> list = new ArrayList<City>();
		list = cityRepository.findAll();
		return list;
	}
	
	@RequestMapping("/cityById")
	public City getCitiesByCityId(@RequestParam("cityId") int cityId){
		City city = cityRepository.getCityById(cityId);
		return city;
	}
	
	@RequestMapping("/citiesByProvince")
	public List<City> getCitiesByProvince(@RequestParam("province") String province){
		List<City> list = new ArrayList<City>();
		list = cityRepository.getCitiesByProvince(province);
		return list;
	}
	
}
