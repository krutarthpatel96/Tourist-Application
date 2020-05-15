package dal.cloud.tourism.InformationService.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dal.cloud.tourism.InformationService.repository.ProvinceRepository;

@RestController
@RequestMapping("provinces")
public class ProvinceController {
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	@RequestMapping("/all")
	public List<String> getProvinces(){
		List<String> list = new ArrayList<String>();
		list = provinceRepository.getProvinces();
		return list;
	}
}
