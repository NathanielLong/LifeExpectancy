package co.gc.HeartbeatCountDown.model.causes;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class CauseLabel {

		private ArrayList<Cause> code;

		public CauseLabel(ArrayList<Cause> code) {
			super();
			this.code = code;
		}

		public ArrayList<Cause> getCode() {
			return code;
		}

		public void setCode(ArrayList<Cause> code) {
			this.code = code;
		}
		
		public CauseLabel()
		{
			
		}
		
	}

