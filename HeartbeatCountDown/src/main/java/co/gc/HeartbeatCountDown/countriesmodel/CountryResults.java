package co.gc.HeartbeatCountDown.countriesmodel;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CountryResults {

	private ArrayList<CountryLabel> dimension;

	public ArrayList<CountryLabel> getDimension() {
		return dimension;
	}

	public void setDimension(ArrayList<CountryLabel> dimension) {
		this.dimension = dimension;
	}

	public CountryResults(ArrayList<CountryLabel> dimension) {
		super();
		this.dimension = dimension;
	}
	
	public CountryResults()
	{
		
	}
	
}
