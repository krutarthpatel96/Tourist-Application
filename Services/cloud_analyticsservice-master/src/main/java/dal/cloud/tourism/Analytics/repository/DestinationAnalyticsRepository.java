package dal.cloud.tourism.Analytics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dal.cloud.tourism.Journey;

@Repository
public interface DestinationAnalyticsRepository extends JpaRepository<Journey, Integer> {
	
	@Query(value = "select c.name, c.province, COUNT(j.journey_Id) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "GROUP BY (c.name)",
			nativeQuery = true)
	public List<Object []> getJourneyStatsForAllDestinations();

	@Query(value = "select c.name, c.province, MONTHNAME(j.date), COUNT(j.journey_Id) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "GROUP BY (c.name), MONTHNAME(j.date)",
			nativeQuery = true)
	public List<Object []> getJourneyStatsForAllDestinationsByMonth();
	
	@Query(value = "select c.name, c.province, YEAR(j.date), COUNT(j.journey_Id) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "GROUP BY (c.name), YEAR(j.date)",
			nativeQuery = true)
	public List<Object []> getJourneyStatsForAllDestinationsByYear();
	
	@Query(value = "select c.name, c.province, SUM(b.seat_capacity-b.seats_available) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "JOIN booking_audit b on j.journey_Id = b.journey_Id "
			+ "GROUP BY (c.name)",
			nativeQuery = true)
	public List<Object []> getCrowdStatsForAllDestinations();
	
	@Query(value = "select c.name, c.province, MONTHNAME(j.date), SUM(b.seat_capacity-b.seats_available) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "JOIN booking_audit b on j.journey_Id = b.journey_Id "
			+ "GROUP BY (c.name), MONTHNAME(j.date)",
			nativeQuery = true)
	public List<Object []> getCrowdStatsForAllDestinationsByMonth();
	
	@Query(value = "select c.name, c.province, YEAR(j.date), SUM(b.seat_capacity-b.seats_available) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "JOIN booking_audit b on j.journey_Id = b.journey_Id "
			+ "GROUP BY (c.name), YEAR(j.date)",
			nativeQuery = true)
	public List<Object []> getCrowdStatsForAllDestinationsByYear();
	
	@Query(value = "select c.name, c.province, COUNT(j.journey_Id) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "WHERE r.destination_Id = :destinationId "
			+ "GROUP BY (c.name)",
			nativeQuery = true)
	public List<Object []> getJourneysbyDestinationId(int destinationId);
	
	@Query(value = "select c.name, c.province, SUM(b.seat_capacity-b.seats_available) "
			+ "FROM city c "
			+ "JOIN route r on c.city_Id = r.destination_id "
			+ "JOIN journey j on j.route_id = r.route_id "
			+ "JOIN booking_audit b on j.journey_Id = b.journey_Id "
			+ "WHERE r.destination_Id = :destinationId "
			+ "GROUP BY (c.name)",
			nativeQuery = true)
	public List<Object []> getCrowdStatsbyDestinationId(int destinationId);
	
}
