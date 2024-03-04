package gameobjects;

public class Actor extends Thing {
	private Event location;
	
	public Actor(String aName, String aDescription, Event aEvent) {
		super(aName, aDescription);
		location=aEvent;
	}
	public void setLocation(Event aEvent) {
		location= aEvent;
	}
	public Event getLocation() {
	return location;
	}
}