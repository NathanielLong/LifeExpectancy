package co.gc.HeartbeatCountDown.countriesmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
@Table
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String label;
	private String display;


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getDisplay() {
		return display;
	}


	public void setDisplay(String display) {
		this.display = display;
	}


	public Country(Integer id, String label, String display) {
		super();
		this.id = id;
		this.label = label;
		this.display = display;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Country(String label, String display) {
		super();
		this.label = label;
		this.display = display;
	}
	
	public Country()
	{
		
	}
	
}
