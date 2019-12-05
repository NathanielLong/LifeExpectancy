package co.gc.HeartbeatCountDown.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class PeopleResults {
	
	
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
