package dal.cloud.tourism.InformationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import dal.cloud.tourism.InformationService.model.City;
import dal.cloud.tourism.InformationService.model.TouristLocation;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
	@Query(value = "SELECT * FROM city c "
			+ "where c.province = :province", nativeQuery = true) 
	public List<City> getCitiesByProvince(String province);
	
	@Query(value = "SELECT * FROM city c "
			+ "where c.city_id = :cityId", nativeQuery = true)
	public City getCityById(int cityId);

}
