package com.spring.entity;


public class Event {

    private int id;
    private String eventName;
    private String organiser;
    private String organiserNumber;
    private Hall hall;
    
    public int getId() {
    	return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getOrganiser() {
		return organiser;
	}
	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}
	public String getOrganiserNumber() {
		return organiserNumber;
	}
	public void setOrganiserNumber(String organiserNumber) {
		this.organiserNumber = organiserNumber;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Event() {}
	
	public Event(int id,String eventName,String organiser,String organiserNumber,Hall hall) {
	   this.id = id;
	   this.eventName = eventName;
        this.organiser = organiser;
        this.organiserNumber = organiserNumber;
        this.hall = hall;
	}

}
