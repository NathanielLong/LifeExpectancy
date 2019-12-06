package co.gc.HeartbeatCountDown.countriesmodel;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CountryLabel {

	private ArrayList<Country> code;

	public CountryLabel(ArrayList<Country> code) {
		super();
		this.code = code;
	}

	public ArrayList<Country> getCode() {
		return code;
	}

	public void setCode(ArrayList<Country> code) {
		this.code = code;
	}
	
	public CountryLabel()
	{
		
	}
	
}
