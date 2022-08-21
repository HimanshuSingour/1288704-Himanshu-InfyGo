package com.infosys.irs.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infosys.irs.entity.Flight;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, String> {

	@Query("select f from Flight f where f.source=:source and f.destination=:dest and f.flightAvailableDate=:jdate")
	List<Flight> findFlightDetails(@Param("source") String source, @Param("dest") String destination,
			@Param("jdate") Date date);

	@Query("select f from Flight f where f.flightId=:flightId")
	Flight findFlight(@Param("flightId") String flightId);

	@Query("select f.source from Flight f")
	List<String> findFlightSources();

	@Query("select f.destination from Flight f")
	List<String> findFlightDestinations();

}
