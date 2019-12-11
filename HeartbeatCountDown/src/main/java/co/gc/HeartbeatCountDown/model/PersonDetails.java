package co.gc.HeartbeatCountDown.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class PersonDetails {

	@JsonProperty("REGION") 
	private String region;
	
	@JsonProperty("YEAR") 
	private int year;
	
	@JsonProperty("COUNTRY") 
	private String country;
	
	@JsonProperty("PUBLISHSTATE") 
	private String publishstate;
	
	@JsonProperty("SEX") 
	private String sex;
	
	@JsonProperty("GHO") 
	private String gho;

	public String getRegion() {
		return region;
	}
	
	

	public PersonDetails(int year, String country, String sex) {
		super();
		this.year = year;
		this.country = country;
		this.sex = sex;
	}



	public void setRegion(String region) {
		this.region = region;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPublishstate() {
		return publishstate;
	}

	public void setPublishstate(String publishstate) {
		this.publishstate = publishstate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGho() {
		return gho;
	}

	public void setGho(String gho) {
		this.gho = gho;
	}

	public PersonDetails(String region, int year, String country, String publishstate, String sex, String gho) {
		super();
		this.region = region;
		this.year = year;
		this.country = country;
		this.publishstate = publishstate;
		this.sex = sex;
		this.gho = gho;
	}
	
	

	public PersonDetails() {
		super();
	}

	@Override
	public String toString() {
		return "PersonDetails [region=" + region + ", year=" + year + ", country=" + country + ", publishstate="
				+ publishstate + ", sex=" + sex + ", gho=" + gho + "]";
	}
	
	
	
}
