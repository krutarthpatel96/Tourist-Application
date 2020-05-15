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
public interface JourneyAnalyticsRepository extends JpaRepository<Journey, Integer> {
	
	@Query(value = "select j.date as date, SUM(b.seat_capacity) as seatCapacity, SUM((b.seat_capacity-b.seats_available)) as freeSeats "
			+ "from booking_audit b "
			+ "JOIN journey j ON b.journey_Id = j.journey_Id "
			+ "GROUP BY (j.date)", 
			nativeQuery = true)
	public List<Object[]> getCrowdStatsForAllJourneys();
	
	@Query(value = "select j.date, b.seat_capacity, (b.seat_capacity-b.seats_available) "
			+ "from booking_audit b "
			+ "JOIN journey j ON b.journey_Id = j.journey_Id "
			+ "WHERE j.journey_Id = :journeyId", 
			nativeQuery = true) 
	public List<Object[]> getJourneyCrowdStatsbyJourneyId(int journeyId);
	
	@Query(value = "select j.date, b.seat_capacity, (b.seat_capacity-b.seats_available) "
			+ "from booking_audit b "
			+ "JOIN journey j ON b.journey_Id = j.journey_Id "
			+ "WHERE j.date = :date", 
			nativeQuery = true)
	public List<Object[]> getJourneyCrowdStatsbyDate(String date);
}
