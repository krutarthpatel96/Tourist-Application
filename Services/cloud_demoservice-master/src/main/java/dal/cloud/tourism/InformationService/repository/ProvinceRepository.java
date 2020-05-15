package dal.cloud.tourism.InformationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dal.cloud.tourism.InformationService.model.City;
import dal.cloud.tourism.InformationService.model.TouristLocation;

@Repository
public interface ProvinceRepository extends JpaRepository<City, Integer> {

	@Query(value = "SELECT DISTINCT(province) FROM City", nativeQuery = true) 
	public List<String> getProvinces();

	
}
