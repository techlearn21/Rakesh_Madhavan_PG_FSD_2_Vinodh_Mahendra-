package com.booking.service; 

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booking.model.Airline;
import com.booking.model.Airport;
import com.booking.model.Flight;
import com.booking.model.LoginUser;
import com.booking.model.SearchFlightRequest;
import com.booking.model.User;
import com.booking.utils.HibernateUtils;

public class FlightService {
	
	
	public Flight getFlight(String flightCode) {
		Flight retrievedFlight = new Flight();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Flight.class);
		criteria.add(Restrictions.eq("code", flightCode));
		List<Flight> flights = criteria.list();
		if(flights.isEmpty()) {
			return retrievedFlight;
		}
		session.close();
		
		return flights.get(0);
	}
	
	public List<Flight> getFlights(SearchFlightRequest request) {
		List<Flight> results = new ArrayList<Flight>();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		System.out.println("Opensession done");
		session.beginTransaction();
		System.out.println("beginTransaction done");
		System.out.println("Going to retrieve results based on object: " + request.toString());
		Criteria criteria = session.createCriteria(Flight.class)
				.add(Restrictions.eq("source", request.getStartFrom()))
				.add(Restrictions.eq("destination", request.getDestination()));
		results = criteria.list();
		System.out.println("Results Retrieved");
		session.close();
		
		if(results.isEmpty()) {
			System.out.println("No results retrieved");;
		}
		
		System.out.println("Search result: " + results);
		
		return results;
	}
	
	
	public List<Airport> getAllAirports() {
		List<Airport> allAirports= new ArrayList<Airport>();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Airport.class);
		allAirports = criteria.list();
		System.out.println("All airports Retrieved");
		session.close();
		
		if(allAirports.isEmpty()) {
			System.out.println("No results retrieved");;
		}
		
		System.out.println("Search result: " + allAirports);
		
		return allAirports;
	
	}
	
	public List<Airline> getAllAirlines() {
		List<Airline> allAirlines = new ArrayList<Airline>();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Airline.class);
		allAirlines = criteria.list();
		System.out.println("All airlines Retrieved");
		session.close();
		
		if(allAirlines.isEmpty()) {
			System.out.println("No results retrieved");;
		}
		
		System.out.println("Search result: " + allAirlines);
		
		return allAirlines;
	
	}


}
