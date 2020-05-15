package dal.cloud.tourism.InformationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import dal.cloud.tourism.InformationService.model.City;

@Repository
public interface SearchRepository extends JpaRepository<City, Integer> {

	@Query(value = "SELECT location_Id, city_Id, name, type, url, features "
			+ "FROM tourist_location "
			+ "where name like %:keyword%", nativeQuery = true) 
	public List<Object []> getTouristLocations(String keyword);
	
	@Query(value = "SELECT city_Id, name, province, url "
			+ "FROM city "
			+ "where name like %:keyword%", nativeQuery = true) 
	public List<Object []> getCities(String keyword);
		
}
