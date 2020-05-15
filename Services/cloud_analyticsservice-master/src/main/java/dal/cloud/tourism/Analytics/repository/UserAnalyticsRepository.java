package dal.cloud.tourism.Analytics.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dal.cloud.tourism.Journey;

@Repository
public interface UserAnalyticsRepository extends JpaRepository<Journey, Integer> {

	@Query(value = "select COUNT(b.booking_Id)" + "FROM booking b "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY (b.user_Id)", nativeQuery = true)
	public List<Object []> getBookingCount(@RequestParam("userId") String userId);

	@Query(value = "select MONTHNAME(j.date), COUNT(b.booking_Id) " 
			+ "FROM booking b "
			+ "JOIN journey j on b.journey_Id = j.journey_Id "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id, MONTHNAME(j.date)", nativeQuery = true)
	public List<Object []> getBookingCountByMonth(@RequestParam("userId") String userId);

	@Query(value = "select YEAR(j.date), COUNT(b.booking_Id) " 
			+ "FROM booking b "
			+ "JOIN journey j on b.journey_Id = j.journey_Id "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id, YEAR(j.date)", nativeQuery = true)
	public List<Object []> getBookingCountByYear(@RequestParam("userId") String userId);
	
	@Query(value = "select COUNT(DISTINCT r.destination_Id) " 
			+ "FROM booking b "
			+ "JOIN journey j on b.journey_Id = j.journey_Id "
			+ "JOIN route r on j.route_Id = r.route_Id "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id", nativeQuery = true)
	public List<Object []> getDestinationsCount(@RequestParam("userId") String userId);

	@Query(value = "select MONTHNAME(j.date), COUNT(DISTINCT r.destination_Id) " 
			+ "FROM booking b "
			+ "JOIN journey j on b.journey_Id = j.journey_Id "
			+ "JOIN route r on j.route_Id = r.route_Id "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id, MONTHNAME(j.date)", nativeQuery = true)
	public List<Object []> getDestinationsCountByMonth(@RequestParam("userId") String userId);

	@Query(value = "select YEAR(j.date), COUNT(DISTINCT r.destination_Id) " 
			+ "FROM booking b "
			+ "JOIN journey j on b.journey_Id = j.journey_Id "
			+ "JOIN route r on j.route_Id = r.route_Id "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id, YEAR(j.date)", nativeQuery = true)
	public List<Object []> getDestinationsCountByYear(@RequestParam("userId") String userId);

	@Query(value = "select SUM(b.amount) " 
			+ "FROM booking b "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id", nativeQuery = true)
	public List<Object []> getMoneySpent(@RequestParam("userId") String userId);

	@Query(value = "select MONTHNAME(j.date), SUM(b.amount) " 
			+ "FROM booking b "
			+ "JOIN journey j on b.journey_Id = j.journey_Id "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id, MONTHNAME(j.date)", nativeQuery = true)
	public List<Object []> getMoneySpentByMonth(@RequestParam("userId") String userId);

	@Query(value = "select YEAR(j.date), SUM(b.amount) " 
			+ "FROM booking b "
			+ "JOIN journey j on b.journey_Id = j.journey_Id "
			+ "WHERE b.user_id = :userId "
			+ "GROUP BY b.user_Id, YEAR(j.date)", nativeQuery = true)
	public List<Object []> getMoneySpentByYear(@RequestParam("userId") String userId);
}
