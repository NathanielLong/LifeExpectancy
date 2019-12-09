package co.gc.HeartbeatCountDown.model.causes;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CauseResults {

	private ArrayList<CauseLabel> dimension;

	public ArrayList<CauseLabel> getDimension() {
		return dimension;
	}

	public void setDimension(ArrayList<CauseLabel> dimension) {
		this.dimension = dimension;
	}

	public CauseResults(ArrayList<CauseLabel> dimension) {
		super();
		this.dimension = dimension;
	}
	
	public CauseResults()
	{
		
	}
	
}
