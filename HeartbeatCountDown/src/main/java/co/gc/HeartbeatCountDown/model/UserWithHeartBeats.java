package co.gc.HeartbeatCountDown.model;



import co.gc.HeartbeatCountDown.model.User;

public class UserWithHeartBeats extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long heartBeats;

	public long getHeartBeats() {
		return heartBeats;
	}

	public void setHeartBeats(long heartBeats) {
		this.heartBeats = heartBeats;
	}

	public UserWithHeartBeats(long heartBeats) {
		super();
		this.heartBeats = heartBeats;
	}
	
	
	


}
	
	
