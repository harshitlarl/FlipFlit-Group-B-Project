package com.flipkart.bean;

public class Gym {
	
	private int gymId;
	private String gymName;
    private String gymAddress;
    private String location;
    private Slots slots;
    
    
    public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymAddress() {
		return gymAddress;
	}
	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
}
	
	public void addSlot(Slots slot) {
		Slots newSlot = new Slots(slot.getSlotsId(),slot.getStartTime(),slot.getSeatCount());
		System.out.println(newSlot.getSeatCount());
		
		
	}
	

}