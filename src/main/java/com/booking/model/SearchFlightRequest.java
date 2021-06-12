package com.booking.model;

import java.util.Date;

public class SearchFlightRequest {
	
	private String startFrom;
	private String destination;
	private int adults;
	private int children;
	private Date startDate;
	private Date returnDate;
	
	public String getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(String startFrom) {
		this.startFrom = startFrom;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date endDate) {
		this.returnDate = endDate;
	}
	
	@Override
	public String toString() {
		return String.format(
				"SearchFlightRequest [startFrom=%s, destination=%s, adults=%s, children=%s, startDate=%s, returnDate=%s]",
				startFrom, destination, adults, children, startDate, returnDate);
	}
	
	
	
}
