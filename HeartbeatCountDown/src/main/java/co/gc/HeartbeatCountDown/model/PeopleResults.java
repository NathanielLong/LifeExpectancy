package co.gc.HeartbeatCountDown.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class PeopleResults {
	
	@JsonProperty("fact")
	private ArrayList<Person> PeopleArray;

	public ArrayList<Person> getPeopleArray() {
		return PeopleArray;
	}

	public void setPeopleArray(ArrayList<Person> peopleArray) {
		PeopleArray = peopleArray;
	}

	public PeopleResults(ArrayList<Person> peopleArray) {
		super();
		PeopleArray = peopleArray;
	}
	
	public PeopleResults()
	{
		
	}

}
