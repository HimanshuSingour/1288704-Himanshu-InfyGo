/**
 * 
 */
package com.infosys.irs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.irs.dto.SearchFlights;
import com.infosys.irs.entity.Flight;
import com.infosys.irs.exception.ARSServiceException;
import com.infosys.irs.repository.FlightsRepository;;

/**
 * The Class AadharService.
 */
@Service
public class FlightService {

	@Autowired
	private FlightsRepository flightsRepository;

	public List<String> getSources() throws ARSServiceException {
		List<String> sources = flightsRepository.findFlightSources();
		if (sources == null) {
			throw new ARSServiceException("No details available");
		} else {
			return sources;
		}
	}

	public List<String> getDestinationss() throws ARSServiceException {
		List<String> destinations = flightsRepository.findFlightDestinations();
		if (destinations == null) {
			throw new ARSServiceException("No details available");
		} else {
			return destinations;
		}
	}

	public List<SearchFlights> getFlights(String source, String destination, Date journeyDate) {

		List<Flight> flights = flightsRepository.findFlightDetails(source, destination, journeyDate);

		List<SearchFlights> availableFlights = new ArrayList<SearchFlights>();
		for (Flight f : flights) {
			SearchFlights flight = new SearchFlights();
			flight.setFlightId(f.getFlightId());
			flight.setSource(f.getSource());
			flight.setDestination(f.getDestination());
			flight.setJourneyDate(f.getFlightAvailableDate());
			flight.setDepartureTime(f.getDepartureTime());
			flight.setArrivalTime(f.getArrivalTime());
			flight.setSeatCount(f.getSeatCount().toString());
			flight.setAirlines(f.getAirlines());
			flight.setFare(Double.toString(f.getFare()));
			availableFlights.add(flight);
		}

		return availableFlights;

	}

	public void updateFlight(String flightId, int noOfSeats) throws ARSServiceException {
		Flight flight = flightsRepository.findById(flightId).get();

		if (flight == null) {
			throw new ARSServiceException("No flight for the given details");
		} else {

			int count = flight.getSeatCount() - Integer.valueOf(noOfSeats);
			flight.setSeatCount(count);
			flightsRepository.saveAndFlush(flight);

		}

	}

	public Flight getFlights(String flightId) {
		return flightsRepository.findById("F101").get();

	}

}
