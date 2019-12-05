package co.gc.HeartbeatCountDown.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	@JsonProperty("dim")
	private PersonDetails pDetails;
	@JsonProperty("Value")
	private double deathAge;
	
	public PersonDetails getpDetails() {
		return pDetails;
	}
	public void setpDetails(PersonDetails pDetails) {
		this.pDetails = pDetails;
	}
	public double getDeathAge() {
		return deathAge;
	}
	public void setDeathAge(double deathAge) {
		this.deathAge = deathAge;
	}
	public Person(PersonDetails pDetails, double deathAge) {
		super();
		this.pDetails = pDetails;
		this.deathAge = deathAge;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [pDetails=" + pDetails + ", deathAge=" + deathAge + "]";
	}
	
	
	
	
}
